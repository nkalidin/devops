package com.spring.bookmydr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

	
}
