package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.data.entity.EndUser;
import com.example.repear_shop.data.entity.Model;
import com.example.repear_shop.service.MVService;
import com.example.repear_shop.service.VisitService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/visits")
public class VisitsViewController {
    private final MVService mvService;

    private final VisitService visitService;
    private final ModelMapper mapper;

    @GetMapping
    public String getVisits(Model model) {
        //find which user is logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EndUser user = (EndUser) authentication.getPrincipal();
        long userId = user.getUserId();

        //TODO: get all visits that have MV with owner with that id
        // -> in list SERVICE HAS GET VISITS BY CLIENT ID


        //TODO: pass the list to frontend

        return "/visits/visits.html";
    }

}
