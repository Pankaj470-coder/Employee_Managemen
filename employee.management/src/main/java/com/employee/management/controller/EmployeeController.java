package com.employee.management.controller;

//import com.example.employee.dto.TaxCalculationResponse;
//import com.example.employee.model.Employee;
//import com.example.employee.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.employee.management.dto.TaxCalculationResponse;
import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/tax-deductions")
    public ResponseEntity<TaxCalculationResponse> getTaxDetails(@PathVariable String id) {
        TaxCalculationResponse response = employeeService.calculateTax(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
