package com.learning.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.app.models.Employee;
import com.learning.app.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping()
    public String getAllEmployee(Model model) {
        List<Employee> employees = service.fetchAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/new")
    public String getEmployeeCreateForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create-employee";
    }

    @GetMapping("/edit/{id}")
    public String getEmployeeEditForm(@PathVariable("id") Long employeeId, Model model) {
        Employee employee = service.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeId) {
        service.deleteEmployeeById(employeeId);
        return "redirect:/employees";
    }

    @PostMapping("/new")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.createEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") Long empolyeeId, @ModelAttribute("employee") Employee employee) {
        service.createEmployee(employee);
        return "redirect:/employees";
    }

}