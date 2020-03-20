package com.mindtree.Employee.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Employee.entity.Employee;
import com.mindtree.Employee.repository.EmployeeRepository;
import com.mindtree.Employee.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		List<Employee> list=empRepo.findAll();
		return list;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.save(employee);
		
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		Employee employee=empRepo.findById(id).get();
		return employee;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}

}
