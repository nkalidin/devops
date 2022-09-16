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
import com.spring.bookmydr.entity.Appointment;
import com.spring.bookmydr.service.AppointmentService;
@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentSevice;
	
	@GetMapping("/appointments")
public List<Appointment> getAllAppointments(){
		return appointmentSevice.getAllAppointments();
	}
	@GetMapping("/appointments/{appointmentId}")
	public Appointment getAppointment(@PathVariable int appointmentId) {
		return appointmentSevice.getAppointment(appointmentId);
	}
	@PostMapping("/appointments")
	public Appointment addAppointment(@Valid @RequestBody Appointment app) {
		return appointmentSevice.addAppointment(app);
	}
	@DeleteMapping("/appointments/{appointmentId}")
	public String deleteAppointment(@PathVariable int appointmentId) {
		return appointmentSevice.deleteAppointment(appointmentId);
	}
	@PutMapping("/appointments/{appointmentId}")
	public Appointment updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment app) {
		return appointmentSevice.updateAppointment(appointmentId,app);
	}
/*	@GetMapping("/appointments/{doctorId}")
	public List<Appointment> getAppointments(@PathVariable int doctorId, Doctor doc){
		return appointmentSevice.getAppointments(doctorId,doc);
	}
	@GetMapping("/appointments/{date}")
	public List<Appointment> getAppointments(@PathVariable LocalDate date){
		return appointmentSevice.getAppointments(date);
	} */
}
