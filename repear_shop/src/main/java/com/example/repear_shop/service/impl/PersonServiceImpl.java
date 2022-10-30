package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.data.repository.PersonRepository;
import com.example.repear_shop.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updatePerson(long id, Person person) {
        person.setId(id);
        return this.personRepository.save(person);
    }

    @Override
    public void deletePerson(long id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public List<Person> findAllByFirstName(String name) {
        return this.personRepository.findAllByFirstName(name);
    }
}
