package com.mindtree.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Employee.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
