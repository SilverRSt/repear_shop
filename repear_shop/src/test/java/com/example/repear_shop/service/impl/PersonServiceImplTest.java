package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.data.repository.MVRepository;
import com.example.repear_shop.data.repository.PersonRepository;
import com.example.repear_shop.dto.PersonCreateDTO;
import com.example.repear_shop.dto.PersonDTO;
import com.example.repear_shop.dto.PersonUpdateDTO;
import com.example.repear_shop.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) //make sure h2database is cleared as not to occur same instances
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) //make sure h2database is cleared as not to occur same instances
public class PersonServiceImplTest {
    private static final String TEST_PASSWORD = "123";
    private static final String TEST_PHONE_NUMBER = "7382942";

    @SpyBean
    private PersonRepository repository;

    @SpyBean
    private MVRepository mvRepository;

    @Autowired
    private PersonServiceImpl service;

    @Autowired
    private MVServicesImpl mvServices;

    private Person personOne;
    private Person personTwo;
    private Person personThree;

    @BeforeEach
    public void setUp() {
        this.personOne = new Person();
        this.personTwo = new Person();
        this.personThree = new Person();

        this.setUpValues();
    }

    @Test
    public void testGetPersons() {
        List<Person> expectedPersons = new ArrayList<>();
        expectedPersons.add(this.personTwo);
        expectedPersons.add(this.personThree);

        Mockito.when(this.repository.findAll()).thenReturn(expectedPersons);
        List<PersonDTO> actualPersons = this.service.getPersons();

        assertEquals(expectedPersons.size(), actualPersons.size());
        assertEquals(expectedPersons.get(0).getFirstName(), actualPersons.get(0).getFirstName());
    }

    @Test
    public void testCreatePerson() {
        PersonCreateDTO expectedPerson = new PersonCreateDTO();
        expectedPerson.setUsername(this.personOne.getUsername());
        expectedPerson.setPassword(this.personOne.getPassword());
        expectedPerson.setFirstName(this.personOne.getFirstName());
        expectedPerson.setLastName(this.personOne.getLastName());
        expectedPerson.setPhoneNumber(this.personOne.getPhoneNumber());

        Person actualPerson = this.service.createPerson(expectedPerson);

        assertEquals(expectedPerson.getFirstName(), actualPerson.getFirstName());
        assertEquals(expectedPerson.getLastName(), actualPerson.getLastName());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test
    public void testUpdatePerson() {
        this.setUpValues();
        String newFirstName = "Andrew";
        String newLastName = "Sebastian";
        String newUsername = "user445";

        PersonCreateDTO person = new PersonCreateDTO();
        person.setUsername(this.personOne.getUsername());
        person.setPassword(this.personOne.getPassword());
        person.setFirstName(this.personOne.getFirstName());
        person.setLastName(this.personOne.getLastName());
        person.setPhoneNumber(this.personOne.getPhoneNumber());

        PersonUpdateDTO expectedPerson = new PersonUpdateDTO();
        expectedPerson.setUsername(newUsername);
        expectedPerson.setPassword(this.personOne.getPassword());
        expectedPerson.setFirstName(newFirstName);
        expectedPerson.setLastName(newLastName);
        expectedPerson.setPhoneNumber(this.personOne.getPhoneNumber());

        this.service.createPerson(person); //create person to be updated
        Person actualPerson = this.service.updatePerson(1, expectedPerson); //update the created person

        assertEquals(expectedPerson.getFirstName(), actualPerson.getFirstName());
        assertEquals(expectedPerson.getLastName(), actualPerson.getLastName());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test
    public void testAddMV() {
//        MV mv = new MV();
//        String vin = "vin";
//        mv.setVin(vin);
//        mv.setRegistrationPlate("registrationPlate");
//        this.mvServices.createMV(mv);
//
//        Mockito.when(this.mvRepository.findOneByVin(vin)).thenReturn(mv);
//
//        PersonCreateDTO person = new PersonCreateDTO();
//        person.setUsername(this.personOne.getUsername());
//        person.setPassword(this.personOne.getPassword());
//        person.setFirstName(this.personOne.getFirstName());
//        person.setLastName(this.personOne.getLastName());
//        person.setPhoneNumber(this.personOne.getPhoneNumber());
//        this.service.createPerson(person);
//
//        Person person1 = new Person();
//        person1.setUsername(this.personOne.getUsername());
//        person1.setPassword(this.personOne.getPassword());
//        person1.setFirstName(this.personOne.getFirstName());
//        person1.setLastName(this.personOne.getLastName());
//        person1.setPhoneNumber(this.personOne.getPhoneNumber());
//        person1.setMvList(new ArrayList<>());
//        Mockito.when(this.repository.getReferenceById(1L)).thenReturn(person1);
//
//        this.service.addMV(1, vin);
//
//
//        Person actualPerson = this.service.getPersonById(1L);
//        assertFalse(actualPerson.getMvList().isEmpty());
//        assertEquals(vin, actualPerson.getMvList().get(0).getVin());
    }

    @Test
    public void testDeletePerson() {
//        PersonCreateDTO person = new PersonCreateDTO();
//        person.setUsername(this.personOne.getUsername());
//        person.setPassword(this.personOne.getPassword());
//        person.setFirstName(this.personOne.getFirstName());
//        person.setLastName(this.personOne.getLastName());
//        person.setPhoneNumber(this.personOne.getPhoneNumber());
//        this.service.createPerson(person);
//
//        Person createdPerson = this.service.getPersonById(Long.parseLong("1"));
//
//        assertEquals(person.getFirstName(), createdPerson.getFirstName());
//
//        //this.service.deletePerson(1);
    }

    private void setUpValues() {
        this.personOne.setUsername("userOne");
        this.personOne.setPassword(TEST_PASSWORD);
        this.personOne.setFirstName("Adam");
        this.personOne.setLastName("Raid");
        this.personOne.setPhoneNumber(TEST_PHONE_NUMBER);
        this.personOne.setMvList(new ArrayList<>());

        this.personTwo.setUsername("userTwo");
        this.personTwo.setPassword(TEST_PASSWORD);
        this.personTwo.setFirstName("Clara");
        this.personTwo.setLastName("Raid");
        this.personTwo.setPhoneNumber(TEST_PHONE_NUMBER);
        this.personTwo.setMvList(new ArrayList<>());

        this.personThree.setUsername("userThree");
        this.personThree.setPassword(TEST_PASSWORD);
        this.personThree.setFirstName("Alaster");
        this.personThree.setLastName("Johnson");
        this.personThree.setPhoneNumber(TEST_PHONE_NUMBER);
        this.personThree.setMvList(new ArrayList<>());
    }
}