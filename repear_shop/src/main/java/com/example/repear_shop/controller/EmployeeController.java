package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Employee;
import com.example.repear_shop.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return this.service.getEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.service.createEmployee(employee);
    }

    @PutMapping("/{employee_id}")
    public Employee updateEmployee(@PathVariable Long employee_id, @RequestBody Employee employee) {
        return this.service.updateEmployee(employee_id, employee);
    }

    @DeleteMapping("/{employee_id}")
    public void deleteEmployee(@PathVariable Long employee_id) {
        this.service.deleteEmployee(employee_id);
    }
}
