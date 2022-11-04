package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long employeeId;


//    @OneToOne
//    @JoinColumn(name = "id")
//    @MapsId
//    private Person personId;

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShopId;

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId"})
    //@JsonIgnoreProperties({"employeeId"})
    private List<Visit> visitList;

//    @OneToMany(mappedBy = "employee")
//    //@JsonIgnoreProperties("employee")
//    @JsonIgnoreProperties({"model", "employee", "brand"})
//    private List<MV> mvList;

//    public Person getPersonId() {
//        return personId;
//    }


    public Employee() {
    }

//    public Employee(Long employee_id) {
//        this.employeeId = employee_id;
//    }


    public Employee(long id) {
        super(id);
    }

    public RepairShop getRepairShopId() {
        return repairShopId;
    }

    public void setRepairShopId(RepairShop repairShopId) {
        this.repairShopId = repairShopId;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}
