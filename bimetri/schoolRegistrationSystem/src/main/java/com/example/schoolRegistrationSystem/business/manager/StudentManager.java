package com.example.schoolRegistrationSystem.business.manager;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolRegistrationSystem.business.service.StudentService;
import com.example.schoolRegistrationSystem.dto.StudentDto;
import com.example.schoolRegistrationSystem.exception.NotFoundException;
import com.example.schoolRegistrationSystem.models.Course;
import com.example.schoolRegistrationSystem.models.Student;
import com.example.schoolRegistrationSystem.repository.CourseRepository;
import com.example.schoolRegistrationSystem.repository.StudentRepository;
import com.example.schoolRegistrationSystem.util.GenericResponse;

@Service
public class StudentManager implements StudentService{
	
	private StudentRepository studentRepository;
	private CourseRepository courseRepository;

	
	@Autowired
	public StudentManager(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;

	}


	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	
	@Override
	public List<Student> getAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public GenericResponse addStudentToCourse(Long studentId, Long courseId) {
		
		
		List<Course> courseSet = null;
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("İd Eksik Ya da Yanlış Girilimiş"));
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("İd Eksik Ya da Yanlış Girilimiş"));
		if(course.getNumberOfStudent() < 50 && student.getNumberOfCourse() < 5) {
			courseSet = student.getCourses();
			courseSet.add(course);
			student.setCourses(courseSet);
			course.setNumberOfStudent(course.getNumberOfStudent() + 1);
			student.setNumberOfCourse(student.getNumberOfCourse() + 1);
			studentRepository.save(student);
			return new GenericResponse("Kursa Kayıt Edildi");
		}
		return new GenericResponse("Kursa Kayıt Edilmedi Kontenjan Dolu"); 
		
	}


	@Override
	public StudentDto updateStudent(Long id, StudentDto studentDto) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("İd Eksik Ya da Yanlış Girilmiş"));
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		Student updatedStudent = studentRepository.save(student);
		return StudentDto.of(updatedStudent);
	}


	@Override
	public List<Student> findAllByCourses_CourseName(String courseName) {
		
		return this.studentRepository.findAllByCourses_CourseName(courseName);
	}


	@Override
	public List<Student> findAllNumberOfCourseNull() {
		
		return studentRepository.findAllNumberOfCourseefNull();
	}


	@Override
	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("İd Eksik Ya da Yanlış Girilmiş"));
		studentRepository.delete(student);
		
	}


	

}
