package com.example.repear_shop.data.entity;

import javax.persistence.*;

@Entity
public class Brand {
    @Id
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
