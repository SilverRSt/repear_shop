package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MV {
    @Id
    @Column(name = "vin", nullable = false, length = 17)
    private String vin;

    private String registrationPlate;

    @ManyToOne
    @JoinColumn(name = "person") //only responsible foe database name
    private Person person;

//    @ManyToOne
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "model")
    private Model model;

    private LocalDate yearMade;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public LocalDate getYearMade() {
        return yearMade;
    }

    public void setYearMade(LocalDate yearMade) {
        this.yearMade = yearMade;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
}
