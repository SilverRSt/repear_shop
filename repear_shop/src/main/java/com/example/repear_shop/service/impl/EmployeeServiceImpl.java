package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Employee;
import com.example.repear_shop.data.repository.EmployeeRepository;
import com.example.repear_shop.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.repository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee createEmployeeFromPerson(Long id, Employee employee) {
        employee.setUserId(id);
        return this.repository.save(employee);
    }


    @Override
    public Employee updateEmployee(Long employee_id, Employee employee) {
        employee.setUserId(employee_id);
        return this.repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employee_id) {
        this.repository.deleteById(employee_id);
    }
}
