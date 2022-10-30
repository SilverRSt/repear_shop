package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    Person createPerson(Person person);

    Person updatePerson(long id, Person person);

    void deletePerson(long id);

    List<Person> findAllByFirstName(String name);

}
