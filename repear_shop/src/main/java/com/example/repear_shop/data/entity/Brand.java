package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    private String brand;

    @OneToMany(mappedBy = "brand")
    private List<Model> modelList;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }
}
