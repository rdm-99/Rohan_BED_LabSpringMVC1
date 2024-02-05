package com.learning.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.app.models.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
