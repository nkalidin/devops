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

import com.spring.bookmydr.entity.Doctor;
import com.spring.bookmydr.entity.Patient;
import com.spring.bookmydr.service.PatientService;
@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	@PostMapping("/patients")
public Patient addPatient(@Valid @RequestBody Patient bean) {
		return patientService.addPatient(bean);
	}
	@PutMapping("/patients/{patientId}")
	public Patient updatePatientDetails(@PathVariable int patientId, @RequestBody Patient bean) {
		return patientService.updatePatientDetails(patientId,bean);
	}
	@DeleteMapping("/patients/{patientId}")
	public String removePatientDetails(@PathVariable int patientId) {
		return patientService.removePatientDetails(patientId);
	}
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable int patientId) {
		return patientService.getPatient(patientId);
	}
	@GetMapping("/patients")
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
		}
	/*	@GetMapping("/patients/{doctorId}")
	public List<Patient> getPatientListByDoctor(@PathVariable int doctorId){
		return patientService.getPatientListByDoctor(doctorId);
	}
	@GetMapping("/patients/{appdate}")
	public List<Patient> getPatientListByDate(@PathVariable LocalDate appdate){
		return patientService.getPatientListByDate(appdate);
	} */
}
