package com.employee.management.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
	
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }

}
