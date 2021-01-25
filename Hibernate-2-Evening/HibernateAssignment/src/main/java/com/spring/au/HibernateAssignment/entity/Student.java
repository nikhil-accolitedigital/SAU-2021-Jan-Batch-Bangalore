package com.spring.au.HibernateAssignment.entity;

import javax.persistence.*;
import java.util.Set;


import lombok.Data;

@Entity
@Data
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="phoneNumber")
	private String phoneNumber;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Department department;

	
	
	//getters and setters

	

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	
	

	

}
