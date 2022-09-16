package com.spring.bookmydr.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookmydr.entity.Appointment;
import com.spring.bookmydr.entity.Doctor;
import com.spring.bookmydr.repo.AppointmentRepository;
@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
public List<Appointment> getAllAppointments(){
	return appointmentRepository.findAll();
}

public Appointment getAppointment(int appointmentId) {
	Optional<Appointment> bookmydrContainer=appointmentRepository.findById(appointmentId);
	if(bookmydrContainer.isPresent()) {
	return bookmydrContainer.get();
	}
	else
	return null;
}
	

public Appointment addAppointment(Appointment app) {
	return appointmentRepository.save(app);
}
public String deleteAppointment(int appointmentId) {
	Optional<Appointment> bookmydrContainer=appointmentRepository.findById(appointmentId);
	if(bookmydrContainer.isPresent()) {
		Appointment oldObj=bookmydrContainer.get();
		appointmentRepository.delete(oldObj);
		return "Deleted Successfully!!!!!";
	}else {
		return "The specified id is not present in the DB:"+appointmentId;
	}
}
public Appointment updateAppointment(int appointmentId,Appointment app) {
	Optional<Appointment> bookmydrContainer=appointmentRepository.findById(appointmentId);
	if(bookmydrContainer.isPresent()) {
		Appointment oldObj=bookmydrContainer.get();
		oldObj.setAppointmentStatus(app.getAppointmentStatus());
		oldObj.setRemark(app.getRemark());
		System.out.println("Successfully Updated!!!");
		return appointmentRepository.saveAndFlush(oldObj);
	}
	System.out.println("No Object found with this ID");
	return app;
}
/*public List<Appointment> getAppointments(int doctorId,Doctor doc){
	return (List<Appointment>) appointmentRepository.getById(doctorId);
}
public List<Appointment> getAppointments(LocalDate date){
	return appointmentRepository.findAll();
} */
}
