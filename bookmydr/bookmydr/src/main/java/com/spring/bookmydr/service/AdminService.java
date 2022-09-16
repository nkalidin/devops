package com.spring.bookmydr.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookmydr.entity.Admin;
import com.spring.bookmydr.repo.AdminRepository;
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
public Admin addAdmin(Admin admin) {
	return adminRepository.save(admin);
}
public Admin updateAdmin(int adminId,Admin admin) {
	Optional<Admin> bookmydrContainer=adminRepository.findById(adminId);
	if(bookmydrContainer.isPresent()) {
		Admin oldObj=bookmydrContainer.get();
		oldObj.setContactNumber(admin.getContactNumber());
		oldObj.setAdminName(admin.getAdminName());
		oldObj.setEmail(admin.getEmail());
		oldObj.setPassword(admin.getPassword());
		System.out.println("Successfully Updated!!!");
		return adminRepository.saveAndFlush(oldObj);
	}
	System.out.println("No Object found with this ID");
	return admin;
	
}
public String removeAdmin(int adminId) {
	Optional<Admin> bookmydrContainer=adminRepository.findById(adminId);
	if(bookmydrContainer.isPresent()) {
		Admin oldObj=bookmydrContainer.get();
	 adminRepository.delete(oldObj);
	 return "Deleted Successfully!!!";
	}
	 else {
			return "The specified id is not present in the DB:"+adminId;
		}
}
public List<Admin> viewAdmin(Admin admin) {
	return adminRepository.findAll();
}
}
