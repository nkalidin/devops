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

import com.spring.bookmydr.entity.Admin;
import com.spring.bookmydr.service.AdminService;
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/admins")
public Admin addAdmin(@Valid @RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	@PutMapping("/admins/{adminId}")
	public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) {
		return adminService.updateAdmin(adminId,admin);
	}
	@DeleteMapping("/admins/{adminId}")
	public String removeAdmin(@PathVariable int adminId) {
		return adminService.removeAdmin(adminId);
	}
	@GetMapping("/admins")
	public List<Admin> viewAdmin(Admin admin) {
		return adminService.viewAdmin(admin);
	}
}
