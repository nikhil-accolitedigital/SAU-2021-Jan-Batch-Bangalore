package com.spring.au.HibernateAssignment;


import com.spring.au.HibernateAssignment.repository.StudentJPARepository;
import com.spring.au.HibernateAssignment.repository.StudentRepository;

import com.spring.au.HibernateAssignment.entity.Student;
import com.spring.au.HibernateAssignment.entity.Department;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Transactional
public class HibernateAssignmentApplication implements CommandLineRunner  {
	
	@Resource
    StudentRepository studentRepository;

    @Autowired
    StudentJPARepository studentJPARepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student();
		s1.setName("Rahul");
		s1.setAge(19);
		s1.setAddress("chandigarh");
		s1.setPhoneNumber("9568423565");
		
		Student s2 = new Student();
		s2.setName("Rohit");	
		s2.setAge(21);
		s2.setAddress("ranchi");
		s2.setPhoneNumber("9654123695");
		
		Student s3 = new Student();
		s3.setName("Mohit");
		s3.setAge(18);
		s3.setAddress("delhi");
		s3.setPhoneNumber("7458963214");
		
		Student s4 = new Student();
		s4.setName("Aditi");
		s4.setAge(20);
		s4.setAddress("mumbai");
		s4.setPhoneNumber("7456321456");
		
		Department d1 = new Department();
		d1.setName("Computer Science & Engineering");
		
		Department d2 = new Department();
		d2.setName("Chemical Engineering");
		
		Department d3 = new Department();
		d3.setName("Electrical Engineering");
		
		Department d4 = new Department();
		d4.setName("Mechanical Engineering");
		
		
		s1.setDepartment(d1);
		s2.setDepartment(d2);
		s3.setDepartment(d3);
		s4.setDepartment(d4);
		
		
		d1.setStudent(s1);
		d2.setStudent(s2);
		d3.setStudent(s3);
		d4.setStudent(s4);
		
		
		
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		d1.setStudents(students);
		
	
		
		studentJPARepository.save(s1);
		studentJPARepository.save(s2);
		studentJPARepository.save(s3);
		studentJPARepository.save(s4);
	
		
//Student s5 = new Student();
//	s5.setName("Nikhil");
//	s5.setAge(21);
//	s5.setPhoneNumber("9632145874");
//	s5.setAddress("bangalore");
//	
//	
//	studentRepository.add(s5);
		
//studentRepository.deleteById(5);
		
	
	
		Student result = studentRepository.getById(2);
		 System.out.println("Details Of Student");
		 System.out.println("Id : " + result.getId());
		 System.out.println("Name : " + result.getName());
		 System.out.println("Age : " + result.getAge());
		 System.out.println("Address : " + result.getAddress());
		 System.out.println("Phone Number : "+ result.getPhoneNumber());
	
		

		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
