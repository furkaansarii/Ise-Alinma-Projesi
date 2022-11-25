package com.example.schoolRegistrationSystem.business.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolRegistrationSystem.business.service.CourseService;
import com.example.schoolRegistrationSystem.dto.CourseDto;
import com.example.schoolRegistrationSystem.exception.NotFoundException;
import com.example.schoolRegistrationSystem.models.Course;
import com.example.schoolRegistrationSystem.repository.CourseRepository;

@Service
public class CourseManager implements CourseService{
	
	private CourseRepository courseRepository;
	
	
	@Autowired
	public CourseManager(CourseRepository courseRepository) {

		this.courseRepository = courseRepository;
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	@Override
	public List<Course> getAll() {
		
		return courseRepository.findAll();
	}

	@Override
	public void deleteCourse(Long id) {
		Course course = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("İd Eksik Ya da Yanlış Girilmiş"));
		courseRepository.delete(course);
		
	}

	@Override
	public CourseDto updateCourse(Long id, CourseDto courseDto) {
		Course course = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("İd EKsik Yada Yanlış Girilmiş"));
		course.setCourseName(courseDto.getCourseName());
		Course updatedCourse = courseRepository.save(course);
		return CourseDto.of(updatedCourse);
	}

	@Override
	public List<Course> findAllByStudentSet_FirstNameAndStudentSet_LastName(String firstName, String lastName) {
		
		return this.courseRepository.findAllByStudentSet_FirstNameAndStudentSet_LastName(firstName, lastName);
	}

	@Override
	public List<Course> findAllNullCourses() {
		
		return this.courseRepository.findAllNullCourses();
	}

	
	

}
