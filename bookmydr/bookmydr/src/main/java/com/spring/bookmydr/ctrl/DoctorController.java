package com.spring.bookmydr.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookmydr.entity.AvailabilityDates;
import com.spring.bookmydr.entity.Doctor;
import com.spring.bookmydr.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@PostMapping("/doctors")
	public Doctor addDoctor(@Valid @RequestBody Doctor bean) {
		 return doctorService.addDoctor(bean);
	 }
	 @PutMapping("/doctors/{doctorId}")
	 public Doctor updateDoctorProfile(@PathVariable int doctorId,@RequestBody Doctor bean) {
		 return doctorService.updateDoctorProfile(doctorId,bean);
	 }
/*	 @PostMapping("/dates")
	 public AvailabilityDates addAvailability(@RequestBody AvailabilityDates avail) {
		 return doctorService.addAvailability(avail);
	 }
/*	 @PutMapping("/dates/{id}")
	public AvailabilityDates updateAvailability(@PathVariable int availabilityId,@RequestBody AvailabilityDates bean) {
		 return doctorService.updateAvailability(bean);
	 } */
	 
	 @GetMapping("/doctors/{doctorId}")
	 public Doctor getDoctor(@PathVariable int doctorId) {
		return  doctorService.getDoctor(doctorId);
	 }
	 @DeleteMapping("/doctors/{doctorId}")
	 public String removeDoctor(@PathVariable int doctorId) {
		 return doctorService.removeDoctor(doctorId);
	 }
	 @GetMapping("/doctors")
	 public List<Doctor> getDoctorList(){
		 return doctorService.getDoctorList();
	 }
	 @GetMapping("/doctor/{speciality}")
	 public List<Doctor> getDoctorsList(@PathVariable String speciality){
		 return doctorService.getDoctorList(speciality);
 } 
}
