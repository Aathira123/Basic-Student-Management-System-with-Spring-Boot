package com.aathira.studentmanagementsystem.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

@NotEmpty
 private String firstName;
 private String lastName;

private String email;
 public Long getId() {
	return id;
}
public Student() {

}
public Student(String firstName, String lastName, String email) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String emailId) {
	this.email = emailId;
}

}
