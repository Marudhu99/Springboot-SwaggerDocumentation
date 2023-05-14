package com.springbootSwagger.SwaggerUI.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootSwagger.SwaggerUI.entity.Student;
import com.springbootSwagger.SwaggerUI.service.StudentService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "api/students" , produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{stdById}")
	public ResponseEntity<Student> getStudentById(@PathVariable("stdById") long stdId) {
		return studentService.getStudentById(stdId);
	}

	@PostMapping("/createStd")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/{stdId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("stdId") Long stdId, @RequestBody Student student) {
		return studentService.updateStudent(stdId,student);
	}
	
	@DeleteMapping("/{stdId}")
	@ApiResponse(responseCode = "202")
	public ResponseEntity<Void> deleteStudent(@PathVariable("stdId") Long stdId) {
		return studentService.deleteStudent(stdId);
	}
}
