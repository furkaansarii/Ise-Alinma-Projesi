package com.example.schoolRegistrationSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

import com.example.schoolRegistrationSystem.business.service.StudentService;
import com.example.schoolRegistrationSystem.dto.StudentDto;
import com.example.schoolRegistrationSystem.models.Student;
import com.example.schoolRegistrationSystem.util.GenericResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student")

public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
		studentService.addStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	@PutMapping("/{studentId}/course/{courseId}")
	public GenericResponse addStudentToCourse(@Valid @PathVariable Long studentId, @PathVariable Long courseId) {
		return studentService.addStudentToCourse(studentId, courseId);
	}
	
	@PutMapping("/{id}")
	public StudentDto updateStudent(@Valid @PathVariable Long id, @RequestBody StudentDto studentDto) {
		return studentService.updateStudent(id, studentDto);
	}
	
	@GetMapping("/courseName")
	public List<Student> findAllByCourses_CourseName(@RequestParam String courseName){
		return studentService.findAllByCourses_CourseName(courseName);
	}
	
	
	@GetMapping("/numberIsNull")
	List<Student> finAllNumberOfCourseNull(){
		return studentService.findAllNumberOfCourseNull();
	}
	
	@DeleteMapping("{id}")
	public GenericResponse deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return new GenericResponse("Kullanıcı Sildindi");
	}
	
	
	
	

}
