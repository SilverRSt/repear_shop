package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.EndUser;
import com.example.repear_shop.data.repository.UserRepository;
import com.example.repear_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EndUser user = this.repository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
