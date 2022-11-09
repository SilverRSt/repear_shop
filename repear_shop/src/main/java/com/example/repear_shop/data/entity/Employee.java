package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends Person{

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShopId;

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId"})
    private List<Visit> visitList;

    @ManyToMany(mappedBy = "employees") //name of list from qualification
    private List<Qualification> qualifications;


    public Employee() {
    }
}
