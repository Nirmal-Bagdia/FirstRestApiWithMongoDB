package com.example.demo.serviceimpl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee regiserEmployee(EmployeeRequest request) {

		Employee employee = new Employee();
		employee.setEmpId(request.getEmpId());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setSalary(request.getSalary());

		Employee registeredEmployee = employeeRepository.save(employee);

		if (registeredEmployee != null) {
			log.info("Employee Register successfully");
		}
		return registeredEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee deleteEmployee(long empId) {
		Employee employee = employeeRepository.findByEmpId(empId);
		if (employee != null) {
			employee = employeeRepository.deleteByEmpId(empId);
			log.info("Employee deleted successfully");
		} else
			log.error("Employee not deleting.........");
		return null;
	}

	@Override
	public Employee updateEmployee(EmployeeRequest request) {
		Employee employee = employeeRepository.findByEmpId(request.getEmpId());
		if (employee != null) {
			employee.setFirstName(request.getFirstName());
			employee.setLastName(request.getLastName());
			employee.setSalary(request.getSalary());
			employee = employeeRepository.save(employee);
			if (employee != null) {
				log.info("Employee updated successfully");
			}
		} else {
			log.error("Employee not exist");
		}
		return employee;
	}
}
