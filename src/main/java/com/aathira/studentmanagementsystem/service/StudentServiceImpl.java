package com.aathira.studentmanagementsystem.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aathira.studentmanagementsystem.entities.Student;
import com.aathira.studentmanagementsystem.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo repo;

	@Override
	public List<Student> getAllStudentsService() {
		return repo.findAll();
	}

	@Override
	public void addStudent(Student s) {
		repo.save(s);
		
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}

	@Override
	public void deleteStudent(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Student> searchStudent(String searchval) {
		List<Student> lis= Stream.concat(repo.findByFirstNameContaining(searchval).stream() , repo.findByLastNameContaining(searchval).stream()).collect(Collectors.toList());
		return lis;
		
	}

	
}
