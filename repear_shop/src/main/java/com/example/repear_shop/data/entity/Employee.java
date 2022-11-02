package com.example.repear_shop.data.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;


    @OneToOne
    @JoinColumn(name = "id")
    //@MapsId
    private Person personId;

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShopId;

    public Person getPersonId() {
        return personId;
    }


    public Employee() {
    }

    public Employee(Long employee_id) {
        this.employeeId = employee_id;
    }

    public RepairShop getRepairShopId() {
        return repairShopId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
