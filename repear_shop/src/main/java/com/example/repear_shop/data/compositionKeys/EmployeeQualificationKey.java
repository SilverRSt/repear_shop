package com.example.repear_shop.data.compositionKeys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmployeeQualificationKey implements Serializable {
    private Long employee_id;

    private Long qualification_id;

    public EmployeeQualificationKey() {
    }

    public EmployeeQualificationKey(Long employee_id, Long qualification_id) {
        this.employee_id = employee_id;
        this.qualification_id = qualification_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(Long qualification_id) {
        this.qualification_id = qualification_id;
    }
}
