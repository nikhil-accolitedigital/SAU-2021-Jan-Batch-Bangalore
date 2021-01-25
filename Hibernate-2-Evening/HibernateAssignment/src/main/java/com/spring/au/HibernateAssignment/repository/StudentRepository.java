package com.spring.au.HibernateAssignment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.au.HibernateAssignment.entity.Student;




@Repository
@Transactional
public class StudentRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	

	public void add(Student student) {
		entityManager.persist(student);
	}
	
	public void deleteById(int id) {
		entityManager.remove(entityManager.find(Student.class,id));
	}
	
	public Student update(Student student) {
		return entityManager.merge(student);
	}
	
	public Student getById(int id) {
		return entityManager.find(Student.class,id);
	}
	

}
