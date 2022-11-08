package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getPersons();

    Person createPerson(Person person);

    Person updatePerson(long id, Person person);

    void deletePerson(long id);

    List<Person> getPersonByFirstName(String firstName);

    List<Person> getPersonByLastName(String lastName);

    List<Person> getPersonsStartingWithFirstName(String firstName);

    List<MV> getAllMVsForPersonById(Long id);
}
