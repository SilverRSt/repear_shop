package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long employee_id, Employee employee);

    void deleteEmployee(Long employee_id);
}
