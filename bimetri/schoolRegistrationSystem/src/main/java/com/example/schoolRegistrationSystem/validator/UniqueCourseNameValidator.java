package com.example.schoolRegistrationSystem.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.schoolRegistrationSystem.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueCourseNameValidator implements ConstraintValidator<UniqueCourseName, String> {
	
	private final CourseRepository courseRepository;
	
	@Override
	public boolean isValid(String courseName, ConstraintValidatorContext context) {
		
		return !courseRepository.existsUserByCourseName(courseName);
	}
	
	

}
