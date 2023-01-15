package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @BeforeEach
    public void setUp() {
        this.personOne = new Person();
        this.personTwo = new Person();
        this.personThree = new Person();
    }

    @Test
    public void testFindAllByFirstNameOneMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, TEST_FIRST_NAME, "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("1"), this.repository.findAllByFirstName(TEST_FIRST_NAME).size());
    }

    @Test
    public void testFindAllByFirstNameAllMatch() {
        this.setUpPersonValues(this.personOne, TEST_FIRST_NAME, "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, TEST_FIRST_NAME, "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, TEST_FIRST_NAME, "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("3"), this.repository.findAllByFirstName(TEST_FIRST_NAME).size());
    }

    @Test
    public void testFindAllByFirstNameAllMatchZeroMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", "Alaster", "userThree");

        this.persistAndFlush();
        assertTrue(this.repository.findAllByFirstName(TEST_FIRST_NAME).isEmpty());
    }

    @Test
    public void testFindAllByLastNameOneMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", TEST_LAST_NAME, "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("1"), this.repository.findAllByLastName(TEST_LAST_NAME).size());
    }

    @Test
    public void testFindAllByLastNameAllMatch() {
        this.setUpPersonValues(this.personOne, "Simon", TEST_LAST_NAME, "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", TEST_LAST_NAME, "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", TEST_LAST_NAME, "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("3"), this.repository.findAllByLastName(TEST_LAST_NAME).size());
    }

    @Test
    public void testFindAllByLastNameZeroMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("0"), this.repository.findAllByLastName(TEST_LAST_NAME).size());
        assertTrue(this.repository.findAllByLastName(TEST_LAST_NAME).isEmpty());
    }

    @Test
    public void testFindAllFirstNameStartsWithOneMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("1"), this.repository.findAllByFirstNameStartsWith("S").size());
    }

    @Test
    public void testFindAllFirstNameStartsWithAllMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Serena", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, "Sai", "Alaster", "userThree");

        this.persistAndFlush();
        assertEquals(Integer.valueOf("3"), this.repository.findAllByFirstNameStartsWith("S").size());
    }

    @Test
    public void testFindAllFirstNameStartsWithZeroMatch() {
        this.setUpPersonValues(this.personOne, "Simon", "Fox", "userOne");
        this.setUpPersonValues(this.personTwo, "Natalie", "Reid", "userTwo");
        this.setUpPersonValues(this.personThree, "Adam", "Alaster", "userThree");

        this.persistAndFlush();
        assertTrue(this.repository.findAllByFirstNameStartsWith("R").isEmpty());
    }

    private void persistAndFlush() {
        this.manager.persistAndFlush(this.personOne);
        this.manager.persistAndFlush(this.personTwo);
        this.manager.persistAndFlush(this.personThree);
    }

    private void setUpPersonValues(Person person, String firstName, String lastName, String username) {
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(TEST_PHONE_NUMBER);

        person.setUsername(username);
        person.setPassword(TEST_PASSWORD);
    }
}