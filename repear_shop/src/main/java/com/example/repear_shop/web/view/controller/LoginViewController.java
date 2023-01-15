package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.data.entity.EndUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class LoginViewController {

    @GetMapping
    public String getIndex(Model model, Authentication authentication) {
        Authentication credentials = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());

        EndUser principal = (EndUser) credentials.getPrincipal();
        //model.addAttribute("username", principal.getAuthorities());

        return "index.html";
    }

    @GetMapping("/login")
    private String login() {
        return "login.html";
    }

    @GetMapping("logout")
    private String logout() {
        return "login.html";
    }

    @GetMapping("unauthorized")
    private String unauthorized() {
        return "unauthorized.html";
    }
}
