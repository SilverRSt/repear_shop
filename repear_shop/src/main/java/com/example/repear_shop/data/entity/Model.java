package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    //@JsonIgnoreProperties("model")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId"})
    private List<MV> mvList;

    public Model() {
    }

    public Model(String model) {
        this.model = model;
    }

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

    public List<MV> getMvList() {
        return mvList;
    }

    public void setMvList(List<MV> mvList) {
        this.mvList = mvList;
    }
}
