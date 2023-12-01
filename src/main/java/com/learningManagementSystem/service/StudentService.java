package com.learningManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learningManagementSystem.dao.StudentRepository;
import com.learningManagementSystem.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public String deleteStudentById(Long id) {
		Optional<Student> opEmp = studentRepository.findById(id);
		if (opEmp.isPresent())
			studentRepository.deleteById(id);
		return "Record deleted Sucesfully";
	}
}
