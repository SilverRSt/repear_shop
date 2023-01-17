package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.data.entity.EndUser;
import com.example.repear_shop.data.entity.RepairShop;
import com.example.repear_shop.data.entity.Visit;
import com.example.repear_shop.dto.VisitsDTO;
import com.example.repear_shop.service.MVService;
import com.example.repear_shop.service.UserService;
import com.example.repear_shop.service.VisitService;
import com.example.repear_shop.web.view.model.visits.VisitsViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/visits")
public class VisitsViewController {
    private final MVService mvService;
    private final UserService userService;

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

        model.addAttribute("userId").addAttribute(userId);
        return "/visits/create-visit.html";
    }

//    private void getUserAuthentication() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        userId = this.userService.getUserId(username);
//    }

    private VisitsViewModel convertToVisitViewModel(VisitsDTO visit) {
        return this.mapper.map(visit, VisitsViewModel.class);
    }
}
