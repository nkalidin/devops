package com.spring.bookmydr.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

	
}
