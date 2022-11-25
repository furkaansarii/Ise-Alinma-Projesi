package com.example.schoolRegistrationSystem.business.service;

import java.util.List;

import com.example.schoolRegistrationSystem.dto.CourseDto;
import com.example.schoolRegistrationSystem.models.Course;

public interface CourseService {
	
	public void addCourse(Course course);
	public List<Course> getAll();
	public void deleteCourse(Long id);
	CourseDto updateCourse(Long id, CourseDto courseDto);
	List<Course> findAllByStudentSet_FirstNameAndStudentSet_LastName(String firstName, String lastName);
	List<Course> findAllNullCourses();
}
