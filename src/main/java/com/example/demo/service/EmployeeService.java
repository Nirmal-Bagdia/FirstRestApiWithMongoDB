package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.request.EmployeeRequest;

public interface EmployeeService {

	Employee regiserEmployee(EmployeeRequest request);

	List<Employee> getAllEmployees();

	Employee deleteEmployee(long empId);

	Employee updateEmployee(EmployeeRequest request);

}
