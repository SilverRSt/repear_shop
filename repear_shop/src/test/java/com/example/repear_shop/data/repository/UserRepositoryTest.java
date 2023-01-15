package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.EndUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    private static final String TEST_PASSWORD = "123";
    private static final String TEST_USERNAME = "realisticnine";

    private EndUser userOne;
    private EndUser userTwo;
    private EndUser userThree;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager manager;

    @BeforeEach
    public void setUp() {
        this.userOne = new EndUser();
        this.userTwo = new EndUser();
        this.userThree = new EndUser();
    }

    @Test
    public void testFindByUsernameFindMatch() {
        this.setUpUserValues(this.userOne, "infieldercloak");
        this.setUpUserValues(this.userTwo, TEST_USERNAME);
        this.setUpUserValues(this.userThree, "koalades");

        this.persistAndFlush();
        EndUser user = this.repository.findByUsername(TEST_USERNAME);
        assertEquals(TEST_USERNAME, user.getUsername());
    }

    @Test
    public void testFindByUsernameNoMatch() {
        this.setUpUserValues(this.userOne, "infieldercloak");
        this.setUpUserValues(this.userTwo, "catwhiplash");
        this.setUpUserValues(this.userThree, "koalades");

        this.persistAndFlush();
        EndUser user = this.repository.findByUsername(TEST_USERNAME);
        assertTrue(Objects.isNull(user));
    }

    private void persistAndFlush() {
        this.manager.persistAndFlush(this.userOne);
        this.manager.persistAndFlush(this.userTwo);
        this.manager.persistAndFlush(this.userThree);
    }

    private void setUpUserValues(EndUser user, String username) {
        user.setUsername(username);
        user.setPassword(TEST_PASSWORD);
    }
}