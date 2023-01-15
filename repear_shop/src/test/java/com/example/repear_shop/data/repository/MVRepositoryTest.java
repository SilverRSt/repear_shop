package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.entity.MV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MVRepositoryTest {
    private static final String TEST_REGISTRATION_PLATE = "564 ZWW";
    private static final String TEST_VIN = "5FNRL5H66BB076671";

    @Autowired
    private MVRepository repository;

    @Autowired
    private TestEntityManager manager;

    private MV mvOne;
    private MV mvTwo;
    private MV mvThree;

    @BeforeEach
    public void setUp() {
        this.mvOne = new MV();
        this.mvTwo = new MV();
        this.mvThree = new MV();
    }

    @Test
    public void testFindOneByVinFindMatch() {
//        this.mvOne.setVin("3N1CE2CP2FL385031");
//        this.mvTwo.setVin(TEST_VIN);
//        this.mvThree.setVin("MAJ3P1TE5JC201646");
//
//        this.persistAndFlush();
//        MV mv = this.repository.findOneByVin(TEST_VIN);
//        assertEquals(TEST_VIN, mv.getVin());
    }

    private void persistAndFlush() {
        this.manager.persistAndFlush(this.mvOne);
        this.manager.persistAndFlush(this.mvTwo);
        this.manager.persistAndFlush(this.mvThree);
    }

}