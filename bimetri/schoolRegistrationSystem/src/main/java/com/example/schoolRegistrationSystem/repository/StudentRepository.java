package com.example.schoolRegistrationSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.schoolRegistrationSystem.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findAllByStudentId(Long studentId);
	List<Student> findAllByCourses_CourseName(String courseName);
	
	
	@Query("FROM Student WHERE numberOfCourse<1")
	List<Student> findAllNumberOfCourseefNull();


	
	
}
