package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MV {
    @Id
    @Column(name = "vin", nullable = false, length = 17)
    private String vin;

    private String registrationPlate;

    @ManyToOne
    @JoinColumn(name = "id")
    private Person id;

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

    public Person getId() {
        return id;
    }

    public void setId(Person id) {
        this.id = id;
    }
}
