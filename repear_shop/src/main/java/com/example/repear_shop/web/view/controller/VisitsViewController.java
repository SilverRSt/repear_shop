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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/visits")
public class VisitsViewController {
    private final MVService mvService;
    private final UserService userService;
    private final PersonService personService;
    private final EmployeeService employeeService;
    private final ServiceTypeService serviceTypeService;

    private final VisitService visitService;
    private final ModelMapper mapper;

    //private Long userId;

    @GetMapping
    public String getVisits(Model model) {
        //TODO: find which user is logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

//        EndUser user = (EndUser) authentication.getPrincipal();
//        long userId = user.getUserId();

        //TODO: get user id through username
        String username = authentication.getName();
        Long userId = this.userService.getUserId(username);

        //TODO: get all visits that have MV with owner with that id
        // -> in list SERVICE HAS GET VISITS BY CLIENT ID
        List<VisitsViewModel> userVisits = this.visitService.getAllVisitsForClientDTO(userId)
                .stream()
                .map(this::convertToVisitViewModel)
                .collect(Collectors.toList());

        //TODO: pass the list to frontend
        model.addAttribute("visits", userVisits);

        return "/visits/visits.html";
    }

    @GetMapping("/create-visit")
    public String createVisitForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long userId = this.userService.getUserId(username);

//        EndUser user = (EndUser) authentication.getPrincipal();
//        long userId = user.getUserId();

        model.addAttribute("userId", userId);

        //get user MV`s
        List<MV> userMvs = this.personService.getAllMVsForPersonById(userId);
        model.addAttribute("mvs", userMvs);

        //TODO: get employees ? || choose repair shop -> at random employee assigned ?
        List<Employee> employees = this.employeeService.getEmployees();
        model.addAttribute("employees", employees);

        //TODO: get services
        List<ServiceType> serviceTypes = this.serviceTypeService.getServiceTypes();
        model.addAttribute("services", serviceTypes);

        model.addAttribute("visit", new VisitsCreateViewModel());

        return "/visits/create-visit.html";
    }

    @PostMapping("/create")
    public String createVisit(@Valid @ModelAttribute("visit") VisitsCreateViewModel visit, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/visits/create-visit.html";
        }

        //TODO: get set prices
        Double dummyPrice = 45.55;
        visit.setPrice(dummyPrice);

        this.visitService.createVisit(this.mapper.map(visit, VisitsCreateDTO.class));
        return "redirect:/visits";
    }

    private VisitsViewModel convertToVisitViewModel(VisitsDTO visit) {
        return this.mapper.map(visit, VisitsViewModel.class);
    }
}
