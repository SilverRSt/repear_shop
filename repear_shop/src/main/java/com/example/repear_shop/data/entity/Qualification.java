package com.example.repear_shop.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;

    private String qualification;

    @OneToMany(mappedBy = "qualificationId")
    private List<EmployeeQualification> employees;

    public Qualification() {
    }

    public Qualification(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<EmployeeQualification> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeQualification> employees) {
        this.employees = employees;
    }
}
