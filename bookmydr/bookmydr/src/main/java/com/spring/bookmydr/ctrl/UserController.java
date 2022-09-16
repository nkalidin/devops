package com.spring.bookmydr.ctrl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookmydr.entity.User;
import com.spring.bookmydr.service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService userService;

public User validateUser(User user) {
		return userService.validateUser(user);
	}
	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}
	@DeleteMapping("/users/{userId}")
	public String removeUser(@PathVariable int userId) {
		return userService.removeUser(userId);
	}
	@PutMapping("/users/{userId}")
	public User updateUser(@PathVariable int userId,@RequestBody User user) {
		return userService.updateUser(userId,user);
	}
}
