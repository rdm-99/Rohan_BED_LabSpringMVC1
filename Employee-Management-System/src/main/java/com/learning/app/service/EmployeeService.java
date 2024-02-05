package com.learning.app.service;

import java.util.List;

import com.learning.app.models.Employee;

public interface EmployeeService {

    void createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    List<Employee> fetchAllEmployees();

    void deleteEmployeeById(Long employeeId);

}