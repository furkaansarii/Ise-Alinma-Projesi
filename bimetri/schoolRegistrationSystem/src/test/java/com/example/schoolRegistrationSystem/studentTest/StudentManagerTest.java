package com.example.schoolRegistrationSystem.studentTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.schoolRegistrationSystem.business.manager.StudentManager;
import com.example.schoolRegistrationSystem.models.Student;
import com.example.schoolRegistrationSystem.repository.CourseRepository;
import com.example.schoolRegistrationSystem.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


import java.util.List;
import java.util.Optional;

public class StudentManagerTest {

	
	private StudentRepository studentRepository;
	private CourseRepository courseRepository;
	private StudentManager studentManager;
	
	@BeforeEach
	public void setUp(){
		studentRepository=Mockito.mock(StudentRepository.class);
		courseRepository=Mockito.mock(CourseRepository.class);	
		studentManager=new StudentManager(studentRepository,courseRepository);
	}
	
	@Test
	public void testCreateStudent_itShouldReturnStudentEntity() {
		
		//given
		
		Student student= new Student("Ali","Yılmaz");
		Student savedStudent= new Student(1L,"Ali","Yılmaz",0);
	
		
		//when
		when(studentRepository.save(student)).thenReturn(savedStudent);
		
		//then
		
		Student result=studentManager.addStudent(student);
		Assertions.assertEquals(student,student);
		
		verify(studentRepository).save(student);
		
	}
}
