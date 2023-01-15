package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EndUser, Long> {
    EndUser findByUsername(String username);
}
