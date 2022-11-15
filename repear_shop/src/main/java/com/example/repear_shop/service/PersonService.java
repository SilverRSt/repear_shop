package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.dto.PersonCreateDTO;
import com.example.repear_shop.dto.PersonDTO;
import com.example.repear_shop.dto.PersonUpdateDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getPersons();

    Person createPerson(PersonCreateDTO person);

    //Person updatePerson(long id, Person person);
    Person updatePerson(long id, PersonUpdateDTO person);

    void addMV(long id, String mvVin);

    void deletePerson(long id);

    Person getPersonById(Long id);

    List<Person> getPersonByFirstName(String firstName);

    List<Person> getPersonByLastName(String lastName);

    List<Person> getPersonsStartingWithFirstName(String firstName);

    List<MV> getAllMVsForPersonById(Long id);

    List<MV> getAllMvsNotBelongingToPerson(Long id);
}
