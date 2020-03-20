package com.mindtree.Employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Employee.entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> listAll();

	void save(Employee employee);

	Employee get(int id);

	void delete(int id);

}
