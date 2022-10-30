package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MV {
    @Id
    @Column(name = "vin", nullable = false, length = 17)
    private String vin;

    private String registrationPlate;

    private String ownerId;

    private String model;

    @Temporal(TemporalType.TIMESTAMP)
    private Date yearMade;

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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getYearMade() {
        return yearMade;
    }

    public void setYearMade(Date yearMade) {
        this.yearMade = yearMade;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
