package com.spring.bookmydr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.AvailabilityDates;
import com.spring.bookmydr.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	List<Doctor> findBySpeciality(String speciality);

	// AvailabilityDates save(AvailabilityDates avail);

	
	}

