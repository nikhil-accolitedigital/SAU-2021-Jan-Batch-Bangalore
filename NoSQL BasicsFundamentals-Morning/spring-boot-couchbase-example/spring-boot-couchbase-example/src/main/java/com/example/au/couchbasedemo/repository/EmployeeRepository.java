package com.example.au.couchbasedemo.repository;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import com.example.au.couchbasedemo.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, String> {
	List<Employee> findByAddress(String address);

	List<Employee> findByPincode(String pincode);
	
}