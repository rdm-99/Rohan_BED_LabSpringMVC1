package com.learning.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.app.dao.EmployeeDao;
import com.learning.app.models.Employee;
import com.learning.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public void createEmployee(Employee employee) {
        try {
            employeeDao.saveAndFlush(employee);
        } catch (Exception e) {
            String msg = "CreateEmployeeException: " + e.getMessage();
            throw new RuntimeException(msg);
        }
    }

    public Employee getEmployeeById(Long employeeId) {
        try {
            return employeeDao.findById(employeeId)
                    .orElseThrow(() -> new IllegalArgumentException("Not a valid employeeId(" + employeeId + ")"));
        } catch (Exception e) {
            String msg = "GetEmployeeByIdException: " + e.getMessage();
            throw new RuntimeException(msg);
        }
    }

    public List<Employee> fetchAllEmployees() {
        try {
            return employeeDao.findAll();
        } catch (Exception e) {
            String msg = "FetchAllEmployeesException: " + e.getMessage();
            throw new RuntimeException(msg);
        }
    }

    public void deleteEmployeeById(Long employeeId) {
        try {
            employeeDao.deleteById(employeeId);
        } catch (Exception e) {
            String msg = "DeleteEmployeeByIdException: " + e.getMessage();
            throw new RuntimeException(msg);
        }
    }
}
