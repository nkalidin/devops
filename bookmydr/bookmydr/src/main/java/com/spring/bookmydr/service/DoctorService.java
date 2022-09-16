package com.spring.bookmydr.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookmydr.entity.AvailabilityDates;
import com.spring.bookmydr.entity.Doctor;
import com.spring.bookmydr.repo.DoctorRepository;
@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
 public Doctor addDoctor(Doctor bean) {
	 return doctorRepository.save(bean);
 }
 
 public Doctor updateDoctorProfile(int doctorId,Doctor doc) {
	 Optional<Doctor> bookmydrContainer=doctorRepository.findById(doctorId);
		if(bookmydrContainer.isPresent()) {
			Doctor oldObj=bookmydrContainer.get();
			oldObj.setSpeciality(doc.getSpeciality());
			oldObj.setLocation(doc.getLocation());
			oldObj.setHospitalName(doc.getHospitalName());
			oldObj.setMobileNo(doc.getMobileNo());
			oldObj.setPassword(doc.getPassword());
			System.out.println("Successfully Updated!!!");
			return doctorRepository.saveAndFlush(oldObj);
		}
		System.out.println("No Object found with this ID");
		return doc;
 }
 /*public AvailabilityDates addAvailability(AvailabilityDates avail) {
	 return doctorRepository.save(avail);
 }
/*public AvailabilityDates updateAvailability(AvailabilityDates obj) {
	 return doctorRepository.saveAll(obj);
 } */
 public Doctor getDoctor(int doctorId) {
	 Optional<Doctor> bookmydrContainer=doctorRepository.findById(doctorId);
		if(bookmydrContainer.isPresent()) {
		return bookmydrContainer.get();
		}
		else
		return null;
	
 }
 public String removeDoctor(int doctorId) {
	 Optional<Doctor> bookmydrContainer=doctorRepository.findById(doctorId);
		if(bookmydrContainer.isPresent()) {
			Doctor oldObj=bookmydrContainer.get();
			doctorRepository.delete(oldObj);
			return "Deleted Successfully!!!!!";
		}else {
			return "The specified id is not present in the DB:"+doctorId;
		}
 }
 
 public List<Doctor> getDoctorList(){
	 return doctorRepository.findAll();
 }
 
 public List<Doctor> getDoctorList(String speciality){
	 return  doctorRepository.findBySpeciality(speciality);
 } 
}
