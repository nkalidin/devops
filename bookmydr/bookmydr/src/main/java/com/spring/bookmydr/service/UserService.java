package com.spring.bookmydr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookmydr.entity.Patient;
import com.spring.bookmydr.entity.User;
import com.spring.bookmydr.repo.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
public User validateUser(User user) {
	return user;
}

public User addUser(User user) {
	return userRepository.save(user);
}

public String removeUser(int userId) {
	Optional<User> bookmydrContainer=userRepository.findById(userId);
	if(bookmydrContainer.isPresent()) {
		User oldObj=bookmydrContainer.get();
		userRepository.delete(oldObj);
		return "Deleted Successfully!!!!!";
	}else {
		return "The specified id is not present in the DB:"+userId;
	}
}

public User updateUser(int userId,User user) {
	Optional<User> bookmydrContainer=userRepository.findById(userId);
	if(bookmydrContainer.isPresent()) {
		User oldObj=bookmydrContainer.get();
		oldObj.setUserName(user.getUserName());
		oldObj.setPassword(user.getPassword());
		System.out.println("Successfully Updated!!!");
		return userRepository.saveAndFlush(oldObj);
	}
	System.out.println("No Object found with this ID");
	return user;
}
}
