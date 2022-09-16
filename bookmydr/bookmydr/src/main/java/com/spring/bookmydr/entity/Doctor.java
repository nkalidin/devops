package com.spring.bookmydr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int doctorId;
	@NotNull(message="Name column must be filled")
	@Pattern(regexp="[A-Za-z]{4,}")
private String doctorName;
private String speciality;
private String location;
private String hospitalName;
@NotNull(message="Enter your mobile number")
@Pattern(regexp="[0-9]{10}",message="Enter correct mobile number")
private String mobileNo;
@NotNull(message="Enter your email")
@Email(message="Enter Correct Email Id")
private String email;
@NotNull(message="Enter your password")
@Pattern(regexp="[A-Za-z0-9@$*#!]{6,}",message="Your Password should contain min 6 characters")
private String password;
@Min(value=100,message="Your charging price should be more than 100")
private double chargedPerVisit;
public Doctor() {
	super();
	// TODO Auto-generated constructor stub
}
public Doctor(int doctorId, String doctorName, String speciality, String location, String hospitalName, String mobileNo,
		String email, String password, double chargedPerVisit) {
	super();
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.speciality = speciality;
	this.location = location;
	this.hospitalName = hospitalName;
	this.mobileNo = mobileNo;
	this.email = email;
	this.password = password;
	this.chargedPerVisit = chargedPerVisit;
}
public int getDoctorId() {
	return doctorId;
}
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getSpeciality() {
	return speciality;
}
public void setSpeciality(String speciality) {
	this.speciality = speciality;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
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
public double getChargedPerVisit() {
	return chargedPerVisit;
}
public void setChargedPerVisit(double chargedPerVisit) {
	this.chargedPerVisit = chargedPerVisit;
}
@Override
public String toString() {
	return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality + ", location="
			+ location + ", hospitalName=" + hospitalName + ", mobileNo=" + mobileNo + ", email=" + email
			+ ", password=" + password + ", chargedPerVisit=" + chargedPerVisit + "]";
}


}
