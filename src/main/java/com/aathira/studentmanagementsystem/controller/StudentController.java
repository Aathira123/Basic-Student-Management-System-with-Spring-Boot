package com.aathira.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aathira.studentmanagementsystem.entities.Student;
import com.aathira.studentmanagementsystem.service.StudentService;
import com.aathira.studentmanagementsystem.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	private StudentServiceImpl studService;

	public StudentController(StudentServiceImpl studService) {
		this.studService = studService;
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model mod) {
		mod.addAttribute("students", studService.getAllStudentsService());
		return "listview";
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model mod)  {
		Student newstud=new Student();
		mod.addAttribute("createmode", true);
		mod.addAttribute("student", newstud);
		return "create-student";
	}
	
	@PostMapping("/addstudent")
	public String saveStudent(@ModelAttribute Student st, Model m) {


			studService.addStudent(st);
	
		return "redirect:/students";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@ModelAttribute Student st, @PathVariable Long id) {

		Student s=studService.getStudentById(st.getId());

			studService.addStudent(st);
	
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{studId}")
	public String editStudent(@PathVariable Long studId, Model m) {
		
		Student selectedstud= studService.getStudentById(studId);
		m.addAttribute("createmode", false);
		m.addAttribute("student",selectedstud);
		return "create-student";
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studService.deleteStudent(id);
		return "redirect:/students";
	}

	
	@GetMapping("/search")
	public String searchStudent(@RequestParam(value="searchval") String searchval, Model m) {
		m.addAttribute("students", studService.searchStudent(searchval));
		System.out.println(studService.searchStudent(searchval));
		return "listview";
	}
	

}
