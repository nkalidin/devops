package com.spring.bookmydr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
}
