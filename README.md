# Convenia API Java Client

A Java client library for integrating with the Convenia HR SaaS platform, designed for Brazilian companies to manage employee data, departments, and HR operations.

## Overview

This library provides a simple interface to interact with Convenia's REST API, allowing you to:

- Retrieve employee information and manage employee data
- Access department and job structures
- Handle cost centers and organizational data
- Manage leave requests and holidays
- Track employee dismissals and changes
- Audit employee record modifications

## Requirements

- JDK 11 or higher
- Maven 3.x

## Key Features

- **Employee Management**: Get employees by ID, email, or paginated lists
- **Organizational Data**: Access departments, jobs, and cost centers
- **Leave Management**: Retrieve employee holidays and leave requests
- **Dismissal Tracking**: Monitor employee dismissals with pagination
- **Audit Trail**: Track employee changes and modifications
- **Async Support**: CompletableFuture support for non-blocking operations

## Main API Methods

```java
ApiClient client = new ApiClientImpl(token, baseUrl);

// Get employees
Response<List<Employee>> employees = client.getEmployees();
Response<Employee> employee = client.getEmployee("employee-id");

// Get organizational data
Response<List<Department>> departments = client.getDepartments();
Response<List<Job>> jobs = client.getJobs();
Response<List<CostCenter>> costCenters = client.getCostCenters();

// Get leave requests
Response<List<LeaveRequest>> holidays = client.getEmployeeHolidays("employee-id");

// Track changes
Response<List<Audit>> changes = client.getEmployeeChanges("employee-id");
```

## Testing

The project includes integration tests with mock server support:

```bash
mvn test
```

## Dependencies

- Jackson for JSON processing
- SLF4J for logging
- JUnit 5 and Mockito for testing
- Spark Java for mock server (test only)

## License

See LICENSE file for details.