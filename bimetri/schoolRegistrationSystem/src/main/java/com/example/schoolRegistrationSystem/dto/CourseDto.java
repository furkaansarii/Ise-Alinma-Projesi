package com.example.schoolRegistrationSystem.dto;

import com.example.schoolRegistrationSystem.models.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
	
	private String courseName;
	
	public static CourseDto of(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseName(course.getCourseName());
		return courseDto;
	}

}
