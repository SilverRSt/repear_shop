package com.example.repear_shop.service;

import com.example.repear_shop.data.compositionKeys.EmployeeQualificationKey;
import com.example.repear_shop.data.entity.EmployeeQualification;

import java.util.List;

public interface EmployeeQualificationService {
    List<EmployeeQualification> getAllEmployeeQualifications();

    EmployeeQualification createEmployeeQualification(EmployeeQualification employeeQualification);

    EmployeeQualification updateEmployeeQualification(EmployeeQualificationKey id,EmployeeQualification employeeQualification);

    void deleteEmployeeQualification(EmployeeQualificationKey id);
}
