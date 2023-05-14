package com.springbootSwagger.SwaggerUI.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootSwagger.SwaggerUI.entity.Student;

@Service
public interface StudentService {

	ResponseEntity<List<Student>> getAllStudents();

	ResponseEntity<Student> getStudentById(long stdId);

	ResponseEntity<Student> createStudent(Student student);

	ResponseEntity<Student> updateStudent(Long stdId, Student student);

	ResponseEntity<Void> deleteStudent(Long stdId);

}
