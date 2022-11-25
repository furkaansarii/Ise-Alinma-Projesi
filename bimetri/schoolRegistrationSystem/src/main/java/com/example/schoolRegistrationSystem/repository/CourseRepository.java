package com.example.schoolRegistrationSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.schoolRegistrationSystem.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findAllByCourseId(Long courseId);
	List<Course> findAllByStudentSet_FirstNameAndStudentSet_LastName(String firstName, String lastName);
	boolean existsUserByCourseName(String courseName);
	@Query("FROM Student WHERE numberOfStudent<1")
	List<Course> findAllNullCourses();
	
	

}
