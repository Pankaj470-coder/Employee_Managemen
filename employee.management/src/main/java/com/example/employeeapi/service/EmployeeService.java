package com.example.employeeapi.service;

//import com.example.employee.dto.TaxCalculationResponse;
//import com.example.employee.exception.EmployeeNotFoundException;
//import com.example.employee.model.Employee;
//import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeapi.dto.TaxCalculationResponse;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.exception.EmployeeNotFoundException;
import com.example.employeeapi.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public TaxCalculationResponse calculateTax(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);

        if (!employeeOpt.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found with id " + employeeId);
        }

        Employee employee = employeeOpt.get();
        double yearlySalary = employee.getSalary();
        double taxAmount = calculateTaxAmount(yearlySalary);
        double cessAmount = calculateCessAmount(yearlySalary);

        return new TaxCalculationResponse(employee.getEmployeeId(), employee.getFirstName(),
                employee.getLastName(), yearlySalary, taxAmount, cessAmount);
    }

    private double calculateTaxAmount(double yearlySalary) {
        if (yearlySalary <= 250000) {
            return 0;
        } else if (yearlySalary <= 500000) {
            return (yearlySalary - 250000) * 0.05;
        } else if (yearlySalary <= 1000000) {
            return (250000 * 0.05) + (yearlySalary - 500000) * 0.10;
        } else {
            return (250000 * 0.05) + (500000 * 0.10) + (yearlySalary - 1000000) * 0.20;
        }
    }

    private double calculateCessAmount(double yearlySalary) {
        if (yearlySalary > 2500000) {
            return (yearlySalary - 2500000) * 0.02;
        }
        return 0;
    }
}
