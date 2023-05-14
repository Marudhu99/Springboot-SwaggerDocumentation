package com.springbootSwagger.SwaggerUI.serviceImplementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.springbootSwagger.SwaggerUI.entity.Student;
import com.springbootSwagger.SwaggerUI.repository.StudentRepository;
import com.springbootSwagger.SwaggerUI.service.StudentService;

@Component
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> findAll = studentRepository.findAll();
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> getStudentById(long stdId) {
		Optional<Student> student = studentRepository.findById(stdId);
		if(student.isPresent()) {
			return ResponseEntity.ok(student.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Student> createStudent(Student student) {
		Student saveStd = studentRepository.save(student);
		return new ResponseEntity<>(saveStd, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Student> updateStudent(Long stdId, Student student) {
	    return studentRepository.findById(stdId)
	            .map(updateStudent -> {
	            	updateStudent.setStdName(student.getStdName());
	            	updateStudent.setDepartment(student.getDepartment());
	                Student savedStudent = studentRepository.save(updateStudent);
	                return ResponseEntity.ok(savedStudent);
	            })
	            .orElseThrow(NoSuchElementException::new);
	}


	@Override
	public ResponseEntity<Void> deleteStudent(Long stdId) {
		if (stdId != null) {
			studentRepository.deleteById(stdId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
