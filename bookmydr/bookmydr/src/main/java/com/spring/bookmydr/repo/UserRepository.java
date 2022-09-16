package com.spring.bookmydr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
}
