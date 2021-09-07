package com.aathira.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.aathira.studentmanagementsystem.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
List<Student> findByFirstNameContaining(String name);
List<Student> findByLastNameContaining(String name);
}
