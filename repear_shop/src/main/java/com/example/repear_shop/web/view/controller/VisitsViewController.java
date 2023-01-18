package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.data.entity.*;
import com.example.repear_shop.dto.VisitsCreateDTO;
import com.example.repear_shop.dto.VisitsDTO;
import com.example.repear_shop.service.*;
import com.example.repear_shop.web.view.model.visits.VisitsCreateViewModel;
import com.example.repear_shop.web.view.model.visits.VisitsViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/visits")
public class VisitsViewController {
    private final UserService userService;
    private final PersonService personService;
    private final EmployeeService employeeService;
    private final ServiceTypeService serviceTypeService;

    private final VisitService visitService;
    private final ModelMapper mapper;

    @GetMapping
    public String getVisits(Model model) {
        //find which user is logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //get user id through username
        String username = authentication.getName();
        Long userId = this.userService.getUserId(username);

        //get all visits that have MV with owner with that id
        List<VisitsViewModel> userVisits = this.visitService.getAllVisitsForClientDTO(userId)
                .stream()
                .map(this::convertToVisitViewModel)
                .collect(Collectors.toList());

        //pass the list to frontend
        model.addAttribute("visits", userVisits);

        return "/visits/visits.html";
    }

    @GetMapping("/create-visit")
    public String createVisitForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long userId = this.userService.getUserId(username);
        model.addAttribute("userId", userId);

        //get user MV`s
        List<MV> userMvs = this.personService.getAllMVsForPersonById(userId);
        model.addAttribute("mvs", userMvs);

        //get employees
        List<Employee> employees = this.employeeService.getEmployees();
        model.addAttribute("employees", employees);

        //get services
        List<ServiceType> serviceTypes = this.serviceTypeService.getServiceTypes();
        model.addAttribute("services", serviceTypes);

        model.addAttribute("visit", new VisitsCreateViewModel());

        return "/visits/create-visit.html";
    }

    @PostMapping("/create")
    public String createVisit(@Valid @ModelAttribute("visit") VisitsCreateViewModel visit, BindingResult bindingResult,
                              @RequestParam("serviceIds") List<Long> serviceIds) {
        if(bindingResult.hasErrors()) {
            return "/visits/create-visit.html";
        }

        List<ServiceType> services = new ArrayList<>();
        serviceIds.forEach(s -> {
            ServiceType service = this.serviceTypeService.getServiceById(s);
            services.add(service);
        });

        visit.getServices().addAll(services);

        double finalPrice = services.stream().mapToDouble(ServiceType::getPrice).sum();
        visit.setPrice(Math.round(finalPrice * 100.0) / 100.0);

        Visit createdVisit = this.visitService.createVisit(this.mapper.map(visit, VisitsCreateDTO.class));

        //UPDATE THE OTHER SIDE OF THE MANY TO MANY -> ADD TO THE SERVICES
        // SO THE TABLE visit_services CAN UPDATE ITSELF AS WELL!!!
        services.forEach(s -> {
            s.getVisits().add(createdVisit);
            this.serviceTypeService.updateService(s.getServiceId(), s);
        });

        return "redirect:/visits";
    }

    private VisitsViewModel convertToVisitViewModel(VisitsDTO visit) {
        return this.mapper.map(visit, VisitsViewModel.class);
    }
}
