package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.payload.EmployeePayload;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

	void save(EmployeePayload employee);

	Employee findByEmpId(long empId);

	Employee deleteByEmpId(long empId);

}
