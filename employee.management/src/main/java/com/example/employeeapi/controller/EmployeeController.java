package com.example.employeeapi.controller;

//import com.example.employee.dto.TaxCalculationResponse;
//import com.example.employee.model.Employee;
//import com.example.employee.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.employeeapi.dto.TaxCalculationResponse;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/tax/{id}")
    public ResponseEntity<TaxCalculationResponse> getTaxDetails(@PathVariable Long id) {
        TaxCalculationResponse response = employeeService.calculateTax(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
