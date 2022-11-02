package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Model {
    @Id
    private String model;

    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<MV> mvList;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
