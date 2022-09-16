package com.spring.bookmydr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="User_Tb")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@NotNull(message="Name column must be filled")
	@Pattern(regexp="[A-Za-z]{4,}")
	private String userName;
	@Column(name="User_Pass")
	@NotNull(message="Enter your password")
	@Pattern(regexp="[A-Za-z0-9@$*#!]{6,}",message="Your Password should contain min 6 characters")
	private String password;
	@Enumerated(value=EnumType.STRING)
	private Role role;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int userId, String userName, String password, Role role) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
	this.role = role;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
}

}
