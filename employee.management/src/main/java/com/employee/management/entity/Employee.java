package com.employee.management.entity;

import lombok.Data;
//import javax.persistence.*;
//import javax.validation.constraints.*;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
@Entity
public class Employee {

    @Id
    @Column(unique = true, nullable = false)
    @NotBlank(message = "EmployeeId is mandatory")
    @Pattern(regexp = "^[a-zA-Z]{1}\\w{1,}$", message = "Employee ID must start with One alphabetic character")
    private String employeeId;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @ElementCollection
    @NotEmpty(message = "At least one phone number is required")
    private List<@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits") String> phoneNumbers;

    @NotBlank(message = "Date of Joining is mandatory")
    private String dateOfJoining;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumbers=" + phoneNumbers + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary
				+ "]";
	}
    
    
}
