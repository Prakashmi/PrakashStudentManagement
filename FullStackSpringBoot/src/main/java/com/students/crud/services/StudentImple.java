package com.students.crud.services;

import java.util.List;

import com.students.crud.entity.Student;

public interface StudentImple {
	String addStudent(Student s);
	Student getStudent(String kodId);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String deleteStudent(String kodId);
}
