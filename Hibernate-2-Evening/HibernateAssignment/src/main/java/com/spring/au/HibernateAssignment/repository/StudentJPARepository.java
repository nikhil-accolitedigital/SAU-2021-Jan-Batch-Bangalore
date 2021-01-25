package com.spring.au.HibernateAssignment.repository;


//import com.spring.au.entity.Student;
import org.springframework.data.repository.CrudRepository;

import com.spring.au.HibernateAssignment.entity.Student;

public interface StudentJPARepository extends CrudRepository<Student,Integer>{
	public Student getStudentById(int id);
	public Student getStudentByName(String name);
	

}
