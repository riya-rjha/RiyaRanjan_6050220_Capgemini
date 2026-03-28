package cg.demo.controller;

import cg.demo.entity.Employee;
import cg.demo.dto.*;
import cg.demo.services.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Insert employee
    @PostMapping("/employee/{deptName}")
    public Employee insertEmployee(@Valid @RequestBody Employee emp,
                                   @PathVariable String deptName) {
        return service.insertEmployee(emp, deptName);
    }

    // Fetch all employees
    @GetMapping("/employees")
    public List<EmployeeDeptDTO> getAll() {
        return service.getAllEmployees();
    }

    // Count employees per department
    @GetMapping("/employees/count")
    public List<DepartmentCountDTO> getCount() {
        return service.getEmployeeCountByDept();
    }

    // Employees by department name
    @GetMapping("/employees/department/{name}")
    public List<Employee> getByDept(@PathVariable String name) {
        return service.getEmployeesByDept(name);
    }

    // Employee by mobile
    @GetMapping("/employee/mobile/{mobile}")
    public EmployeeMobileDTO getByMobile(@PathVariable String mobile) {
        return service.getByMobile(mobile);
    }
}