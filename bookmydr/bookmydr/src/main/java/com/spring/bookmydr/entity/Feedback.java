package com.spring.bookmydr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
	@NotNull(message="Your Rating should be in 1 to 5")
	@Min(value=1,message="Your Rating should be in 1 to 5")
	@Max(value=5,message="Your Rating should be in 1 to 5")
	private int rating;
	@OneToOne
	@JoinColumn(name="Patient_Fdb")
	private Patient patient;
	@OneToOne
	@JoinColumn(name="Doctor_Fdb")
	private Doctor doctor;
	@Pattern(regexp="[A-Za-z]{6,}",message="your comment line should contain min 6 characters")
	private String feedbackComment;
public Feedback() {
	super();
	// TODO Auto-generated constructor stub
}
public Feedback(int feedbackId, int rating, Patient patient, Doctor doctor, String feedbackComment) {
	super();
	this.feedbackId = feedbackId;
	this.rating = rating;
	this.patient = patient;
	this.doctor = doctor;
	this.feedbackComment = feedbackComment;
}
public int getFeedbackId() {
	return feedbackId;
}
public void setFeedbackId(int feedbackId) {
	this.feedbackId = feedbackId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
public String getFeedbackComment() {
	return feedbackComment;
}
public void setFeedbackComment(String feedbackComment) {
	this.feedbackComment = feedbackComment;
}
@Override
public String toString() {
	return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", patient=" + patient + ", doctor=" + doctor
			+ ", feedbackComment=" + feedbackComment + "]";
}

	
}
