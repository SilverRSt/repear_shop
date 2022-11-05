package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByFirstName(String firstName);
    List<Person> findAllByLastName(String lastName);
    List<Person> findAllByFirstNameStartsWith(String firstName);
}
