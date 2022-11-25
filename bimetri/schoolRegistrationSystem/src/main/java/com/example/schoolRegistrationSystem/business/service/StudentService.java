package com.example.schoolRegistrationSystem.business.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.schoolRegistrationSystem.dto.StudentDto;
import com.example.schoolRegistrationSystem.models.Student;
import com.example.schoolRegistrationSystem.util.GenericResponse;

public interface StudentService {
	
	public Student addStudent(Student student);
	public List<Student> getAll();
	public GenericResponse addStudentToCourse(Long studentId, Long courseId);
	StudentDto updateStudent(Long id, StudentDto studentDto);
	List<Student> findAllByCourses_CourseName(String courseName);
	List<Student> findAllNumberOfCourseNull();
	public void deleteStudent(Long id);
	
	
	

}
