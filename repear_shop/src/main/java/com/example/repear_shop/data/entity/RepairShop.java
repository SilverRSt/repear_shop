package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class RepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_shop_id", nullable = false)
    private Long repairShopId;

    private String name;

    private String address;

    @OneToMany(mappedBy = "repairShopId")
    @JsonIgnoreProperties("repairShopId")
    private List<Employee> employeeList;

    public RepairShop() {
    }

    public RepairShop(Long repairShopId) {
        this.repairShopId = repairShopId;
    }

    //private Brand brandRestriction;

    public Long getRepairShopId() {
        return repairShopId;
    }

    public void setRepairShopId(Long repairShopId) {
        this.repairShopId = repairShopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
