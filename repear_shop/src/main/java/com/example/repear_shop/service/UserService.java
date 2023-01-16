package com.example.repear_shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Long getUserId(String username);
}
