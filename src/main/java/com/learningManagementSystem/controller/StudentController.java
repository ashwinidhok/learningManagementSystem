package com.learningManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningManagementSystem.entity.Student;
import com.learningManagementSystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {

		return studentService.createStudent(student);
	}

	@GetMapping("/find/{id}")
	private Student findStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/findAll")
	private List<Student> findAllStudents() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudentById(id);

	}
}
