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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	private String firstName;
	
	private String lastName;
	
	private int numberOfCourse = 0;
	
	@Email(message = "Lütfen Mail Adresinizi Kontrol Ediniz")
	private String mail;
	
	@Pattern(regexp = "5[0-9]\\d{8}",message = "Telefon numaranızın başına 0 koymadan yazınız ve 10 Haneli Giriniz")
	private String phoneNumber;
	
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "student_course",
	joinColumns = @JoinColumn(name = "student_id"),
	inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	@JsonIgnoreProperties(value = {"student"})
	private List<Course> courses;
	
	




	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}






	public Student(Long studentId, String firstName, String lastName, int numberOfCourse) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberOfCourse = numberOfCourse;
	}

	
	
	
}
