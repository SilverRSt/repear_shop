package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.compositionKeys.EmployeeQualificationKey;
import com.example.repear_shop.data.entity.EmployeeQualification;
import com.example.repear_shop.data.repository.EmployeeQualificationRepository;
import com.example.repear_shop.service.EmployeeQualificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeQualificationServiceImpl implements EmployeeQualificationService {
    private final EmployeeQualificationRepository repository;

    public EmployeeQualificationServiceImpl(EmployeeQualificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeQualification> getAllEmployeeQualifications() {
        return this.repository.findAll();
    }

    @Override
    public EmployeeQualification createEmployeeQualification(EmployeeQualification employeeQualification) {
        return this.repository.save(employeeQualification);
    }

    @Override
    public EmployeeQualification updateEmployeeQualification(EmployeeQualificationKey id, EmployeeQualification employeeQualification) {
        employeeQualification.setId(id);
        return this.repository.save(employeeQualification);
    }

    @Override
    public void deleteEmployeeQualification(EmployeeQualificationKey id) {
        this.repository.deleteById(id);
    }
}
