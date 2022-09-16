package com.spring.bookmydr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int adminId;
	@NotNull(message="Admin name cannot be null")
	@Length(min=4,message="Give Proper name")
private String adminName;
	@NotNull(message="Enter your phone number")
	@Pattern(regexp="[0-9]{10}",message="Number Should contain 10 digits")
private String contactNumber;
@Email(message="Invalid Email Id")
private String email;
@Column(name="Password")
@NotNull(message="column cannot be empty")
@Pattern(regexp="[A-Za-z0-9@$*#!]{6,}",message="Your Password should contain min 6 characters")
private String password;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(int adminId, String adminName, String contactNumber, String email, String password) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.contactNumber = contactNumber;
	this.email = email;
	this.password = password;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", contactNumber=" + contactNumber + ", email="
			+ email + ", password=" + password + "]";
}

}
