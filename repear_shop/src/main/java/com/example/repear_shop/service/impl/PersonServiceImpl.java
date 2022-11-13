package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.data.repository.PersonRepository;
import com.example.repear_shop.dto.PersonDTO;
import com.example.repear_shop.dto.PersonUpdateDTO;
import com.example.repear_shop.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    private final ModelMapper mapper;

    public PersonServiceImpl(PersonRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> getPersons() {
        //return this.repository.findAll();
        return this.repository.findAll()
                .stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Person createPerson(Person person) {
        return this.repository.save(person);
    }

    @Override
    public Person updatePerson(long id, PersonUpdateDTO person) {
        person.setId(id);
        return this.repository.save(this.mapper.map(person, Person.class));
    }

    @Override
    public void deletePerson(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return this.repository.findById(id);
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

    private PersonDTO convertToPersonDTO(Person person) {
        return this.mapper.map(person, PersonDTO.class);
    }

}
