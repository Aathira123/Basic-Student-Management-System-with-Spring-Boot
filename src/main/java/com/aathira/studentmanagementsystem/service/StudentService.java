package com.aathira.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aathira.studentmanagementsystem.entities.Student;


public interface StudentService {

List<Student> getAllStudentsService();
void addStudent(Student s);
Student getStudentById(Long id);
void updateStudent(Student s);
void deleteStudent(Long id);
List<Student> searchStudent(String searchval);
}
