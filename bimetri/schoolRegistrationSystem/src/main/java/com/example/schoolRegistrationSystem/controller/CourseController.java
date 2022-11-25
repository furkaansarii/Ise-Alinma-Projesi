package com.example.schoolRegistrationSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolRegistrationSystem.business.service.CourseService;
import com.example.schoolRegistrationSystem.dto.CourseDto;
import com.example.schoolRegistrationSystem.models.Course;
import com.example.schoolRegistrationSystem.util.GenericResponse;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/course")

public class CourseController {
	
	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
		courseService.addCourse(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Course> getAll(){
		return courseService.getAll();
	}
	
	@DeleteMapping("{id}")
	public GenericResponse deleteCourse(@Valid @PathVariable Long id) {
		this.courseService.deleteCourse(id);
		return new GenericResponse("Kullanıcı Silindi");
	}
	
	@PutMapping("{id}")
	public CourseDto updateCourse(@Valid @PathVariable Long id, @RequestBody CourseDto courseDto) {
		return this.courseService.updateCourse(id, courseDto);
	}
	
	@GetMapping("/nameSurname")
	public List<Course> findAllByStudentSet_FirstNameAndLastName(@Valid @RequestParam String firstName, @RequestParam String lastName){
		return courseService.findAllByStudentSet_FirstNameAndStudentSet_LastName(firstName, lastName);
	}
	
	@GetMapping("/NumberIsNull")
	public List<Course> findAllNullCourses(){
		return courseService.findAllNullCourses();
	}
	
	
	

}
