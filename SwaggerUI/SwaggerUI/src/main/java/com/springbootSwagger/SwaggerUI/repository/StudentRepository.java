package com.springbootSwagger.SwaggerUI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootSwagger.SwaggerUI.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
