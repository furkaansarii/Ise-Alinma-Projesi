package com.example.schoolRegistrationSystem.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.schoolRegistrationSystem.validator.UniqueCourseName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	@UniqueCourseName
	@Size(min = 3, max = 35, message = "Lütfen kursun adı {min} ile {max} harf aralığında olsun")
	private String courseName;
	private int numberOfStudent = 0;
	
	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> studentSet;

}
