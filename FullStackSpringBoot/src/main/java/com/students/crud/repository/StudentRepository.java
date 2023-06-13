package com.students.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
