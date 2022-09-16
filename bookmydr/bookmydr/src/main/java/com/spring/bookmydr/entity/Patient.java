package com.spring.bookmydr.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Patient {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int patientId;
@NotNull(message="Name column must be filled")
@Pattern(regexp="[A-Za-z]{4,}")
private String patientName;
@NotNull(message="Enter your mobile number")
@Pattern(regexp="[0-9]{10}",message="Enter correct mobile number")
private String mobileNo;
@NotNull(message="Enter your email")
@Email(message="Enter Correct Email Id")
private String email;
@NotNull(message="Enter your password")
@Pattern(regexp="[A-Za-z0-9@$*#!]{6,}",message="Your Password should contain min 6 characters")
private String password;
@Pattern(regexp="[AaBbOo|ABab][+-]",message="Enter proper blood group")
private String bloodGroup;
@Enumerated(value=EnumType.STRING)
private Gender gender;
@NotNull(message="Enter your age")
@Min(value=1,message="Age cannot be less than 1")
private int age;
@NotNull(message="Enter your Address")
private String address;
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public Patient(int patientId, String patientName, String mobileNo, String email, String password, String bloodGroup,
		Gender gender, int age, String address) {
	super();
	this.patientId = patientId;
	this.patientName = patientName;
	this.mobileNo = mobileNo;
	this.email = email;
	this.password = password;
	this.bloodGroup = bloodGroup;
	this.gender = gender;
	this.age = age;
	this.address = address;
}
public int getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
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
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNo=" + mobileNo + ", email="
			+ email + ", password=" + password + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age
			+ ", address=" + address + "]";
}


}
