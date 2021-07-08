package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/registerEmployee")
	public Employee regiserEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.regiserEmployee(request);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public Employee deleteEmployee(@PathVariable("id") long empId) {
		return employeeService.deleteEmployee(empId);
	}

	@PostMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.updateEmployee(request);
	}

}
