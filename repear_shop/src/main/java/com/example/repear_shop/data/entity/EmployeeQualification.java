package com.example.repear_shop.data.entity;

import com.example.repear_shop.data.compositionKeys.EmployeeQualificationKey;

import javax.persistence.*;

@Entity
public class EmployeeQualification {
    @EmbeddedId
    private EmployeeQualificationKey id;

    @ManyToOne
    @MapsId("employee_id")
    private Employee employeeId;

    @ManyToOne
    @MapsId("qualification_id")
    private Qualification qualificationId;

    public EmployeeQualification() {
    }

    public EmployeeQualification(EmployeeQualificationKey id) {
        this.id = id;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Qualification getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Qualification qualificationId) {
        this.qualificationId = qualificationId;
    }

    public EmployeeQualificationKey getId() {
        return id;
    }

    public void setId(EmployeeQualificationKey id) {
        this.id = id;
    }
}
