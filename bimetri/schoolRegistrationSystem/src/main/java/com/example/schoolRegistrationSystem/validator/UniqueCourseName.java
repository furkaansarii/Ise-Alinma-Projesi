package com.example.schoolRegistrationSystem.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


import java.lang.annotation.Retention;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {UniqueCourseNameValidator.class})
public @interface UniqueCourseName {
	
	String message() default "Bu Kurs Adı Mevcut";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
