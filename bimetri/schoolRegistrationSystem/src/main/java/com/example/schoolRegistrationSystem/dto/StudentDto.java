package com.example.schoolRegistrationSystem.dto;

import com.example.schoolRegistrationSystem.models.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private String firstName;
	private String lastName;
	private String asd;
	
	public static StudentDto of(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		return studentDto;
	}

}
