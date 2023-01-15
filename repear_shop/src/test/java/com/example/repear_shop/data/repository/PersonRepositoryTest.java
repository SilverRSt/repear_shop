package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.data.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {
    private static final String TEST_FIRST_NAME = "John";
    private static final String TEST_LAST_NAME = "John";
    private static final String TEST_PASSWORD = "123";
    private static final String TEST_PHONE_NUMBER = "7382942";
    @Autowired
    private PersonRepository repository;

    @Autowired
    private TestEntityManager manager;

    private Person personOne;
    private Person personTwo;
    private Person personThree;

    private User userOne;
    private User userTwo;
    private User userThree;

    @BeforeEach
    public void setUp() {
        this.userOne = new Person();
        this.userOne.setUsername("userOne");

        this.userTwo = new Person();
        this.userTwo.setUsername("userOne");

        this.userThree = new Person();
        this.userThree.setUsername("userOne");

        this.personOne = new Person();
        this.personTwo = new Person();
        this.personThree = new Person();

        //this.personOne.setUserId(0L);
        //this.personTwo.setUserId(0L);
        //this.personThree.setUserId(0L);
    }

    @Test
    public void testFindAllByFirstNameOnePossible() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, TEST_FIRST_NAME, TEST_LAST_NAME, "userThree");

        this.manager.persistAndFlush(this.personOne);
//        this.manager.persistAndFlush(this.userTwo);
//        this.manager.persistAndFlush(this.userThree);

        //this.manager.persistAndFlush(this.personOne);
//        this.manager.persistAndFlush(this.personTwo);
//        this.manager.persistAndFlush(this.personThree);

        //assertEquals(Integer.parseInt("1"), this.repository.findAllByFirstName(TEST_FIRST_NAME).size());
    }

    @Test
    public void testFindAllByLastName() {

    }

    @Test
    public void testFindAllFirstNameStartsWith() {

    }

    private void setUpPersonValues(Person person, String firstName, String lastName, String username) {
        person.setFirstName(firstName);
        person.setLastName(lastName);

        person.setUsername(username);
        person.setPassword(TEST_PASSWORD);
        person.setPhoneNumber(TEST_PHONE_NUMBER);
    }
}