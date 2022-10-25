package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.service.PersonService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService services;

    public PersonController(PersonService services) {
        this.services = services;
    }

    @GetMapping
    public List<Person> getPersons() {
        return this.services.getPersons();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return this.services.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable long id, @RequestBody Person person) {
        return this.services.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        this.services.deletePerson(id);
    }

//    @GetMapping("/by-name/{name}")
//    public List<Person> getPersonsByName(@PathVariable String name) {
//        return this.services.getPersonsByName(name);
//    }
}
