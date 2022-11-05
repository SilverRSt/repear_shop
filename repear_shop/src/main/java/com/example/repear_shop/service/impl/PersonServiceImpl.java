package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.data.repository.PersonRepository;
import com.example.repear_shop.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return this.repository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        return this.repository.save(person);
    }

    @Override
    public Person updatePerson(long id, Person person) {
        person.setId(id);
        return this.repository.save(person);
    }

    @Override
    public void deletePerson(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Person> getPersonByFirstName(String firstName) {
        return this.repository.findAllByFirstName(firstName);
    }

    @Override
    public List<Person> getPersonByLastName(String lastName) {
        return this.repository.findAllByLastName(lastName);
    }

    @Override
    public List<Person> getPersonsStartingWithFirstName(String firstName) {
        return this.repository.findAllByFirstNameStartsWith(firstName);
    }

    @Override
    public List<MV> getAllMVsForPersonById(Long id) {
        Optional<Person> person = this.repository.findById(id);

        return person.get().getMvList();
    }


}
