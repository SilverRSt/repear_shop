package com.example.repear_shop.controller;

import com.example.repear_shop.data.compositionKeys.EmployeeQualificationKey;
import com.example.repear_shop.data.entity.EmployeeQualification;
import com.example.repear_shop.service.EmployeeQualificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeQualifications")
public class EmployeeQualificationController {
    private final EmployeeQualificationService service;

    public EmployeeQualificationController(EmployeeQualificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeQualification> getAllEmployeeQualifications() {
        return this.service.getAllEmployeeQualifications();
    }

    @PostMapping
    public EmployeeQualification createEmployeeQualification(@RequestBody EmployeeQualification employeeQualification) {
        return this.service.createEmployeeQualification(employeeQualification);
    }

    @PutMapping("/{id}")
    public EmployeeQualification updateEmployeeQualification(@PathVariable EmployeeQualificationKey id,@RequestBody EmployeeQualification employeeQualification) {
        return this.service.updateEmployeeQualification(id, employeeQualification);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeQualification(@PathVariable EmployeeQualificationKey id) {
        this.service.deleteEmployeeQualification(id);
    }
}
