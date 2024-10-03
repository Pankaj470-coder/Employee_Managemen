
# Add DB credential into Application.properties file 
server.port=9095
spring.application.name=employee.management
spring.datasource.url=jdbc:mySql://localhost:3306/schema_name
spring.datasource.username=root // DB user name
spring.datasource.password=Mindgate@123 // DB password 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


# 1. API Endpoint to Store Employee Details

Endpoint: /api/employees
Method: POST
Description: This endpoint Validate employee details and authenticate the user and store employee details into employee table 
Request Body:
json
{
  "employeeId": "E123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumbers": ["1234567890", "0987654321"],
  "dateOfJoining": "2023-05-16",
  "salary": 50000
}

# Testing with Postman/browser
In Postman, when you test the APIs, you can select Basic Auth under the Authorization tab, and provide:

Username: admin
Password: admin123

# Fields:
employeeId (String): Unique identifier for the employee.
firstName (String): First name of the employee.
lastName (String): Last name of the employee.
email (String): Email address of the employee.
phoneNumbers (List<String>): List of phone numbers for the employee.
doj (String): Date of joining in YYYY-MM-DD format.
salary (Double): Monthly salary of the employee.

# 2. API Endpoint to Return Employees' Tax Deductions

Endpoint: /api/employees/{employeeId}/tax-deductions
Method: GET
Description: This endpoint Validate Employee Id , authenticae the user and provide tax deduction details of an employee for the current financial year (April to March).
Response:
json
{
  "employeeId": "E123",
  "firstName": "John",
  "lastName": "Doe",
  "yearlySalary": 600000,
  "taxAmount": 37500,
  "cessAmount": 6000
}

# Testing with Postman
In Postman, when you test the APIs, you can select Basic Auth under the Authorization tab, and provide:

Username: admin
Password: admin123
