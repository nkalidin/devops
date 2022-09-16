package com.spring.bookmydr.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
public class AvailabilityDates {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int availabilityId;
	@OneToOne
	@JoinColumn(name="Doctor_date")
private Doctor doctor;
	@NotNull(message="This field is mandatory")
private Date fromDate;
	@NotNull(message="This field is mandatory")
private Date endDate;
public AvailabilityDates() {
	super();
	// TODO Auto-generated constructor stub
}
public AvailabilityDates(int availabilityId, Doctor doctor, Date fromDate, Date endDate) {
	super();
	this.availabilityId = availabilityId;
	this.doctor = doctor;
	this.fromDate = fromDate;
	this.endDate = endDate;
}
public int getAvailabilityId() {
	return availabilityId;
}
public void setAvailabilityId(int availabilityId) {
	this.availabilityId = availabilityId;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
public Date getFromDate() {
	return fromDate;
}
public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return "AvailabilityDates [availabilityId=" + availabilityId + ", doctor=" + doctor + ", fromDate=" + fromDate
			+ ", endDate=" + endDate + "]";
}


}
