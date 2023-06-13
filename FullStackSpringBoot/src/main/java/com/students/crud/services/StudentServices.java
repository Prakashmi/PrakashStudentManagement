package com.students.crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.students.crud.entity.Student;
import com.students.crud.repository.StudentRepository;
@Service
public class StudentServices implements StudentImple {
 StudentRepository srepo;
 
	public StudentServices(StudentRepository srepo) {
	super();
	this.srepo = srepo;
}

	@Override
	public String addStudent(Student s) {
		srepo.save(s);
		 return "Student added successfully";
	}

	@Override
	public Student getStudent(String kodId) {
		Student st=srepo.findById(kodId).get();
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> lst= srepo.findAll();
		return lst;
	}

	@Override
	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student updated successfully";
	}

	@Override
	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);
		return "Student deleted successfully";
	}

}
