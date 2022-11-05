package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends Person{

    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShopId;

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId"})
    private List<Visit> visitList;

    @OneToMany(mappedBy = "employeeId")
    private List<EmployeeQualification> qualifications;


    public Employee() {
    }

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

    public List<EmployeeQualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<EmployeeQualification> qualifications) {
        this.qualifications = qualifications;
    }
}
