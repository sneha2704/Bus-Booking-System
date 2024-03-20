package com.example.busbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.busbookingsystem.entity.Admin;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin)
    {
   	 Admin ad=adminService.registerAdmin(admin);
   	 return new  ResponseEntity<Admin>(ad,HttpStatus.CREATED);
    }
	
	//login admin using email and password
	@GetMapping("/loginAdmin/{emailId}/{password}")
	public Admin loginAdmin(@PathVariable ("emailId") String emailId,@PathVariable ("password") String password) {
		return adminService.loginAdmin(emailId,password);
	}
	
	@GetMapping("/getAllAdmin")
	List<Admin> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/getAdminById/{adminId}")
	public Admin getAdminById(@PathVariable ("adminId") Integer adminId) throws ResourceNotFoundException
	{
		return adminService.getAdminById(adminId);
	}
	
	@GetMapping("/getAdminByEmail/{emailId}")
	public Admin getAdminByEmail(@PathVariable ("emailId") String emailId)
	{
		return adminService.getAdminByEmail(emailId);
	}
	

    @PutMapping("/updateAdminPassword/{adminId}/{newPassword}")
    public ResponseEntity<Admin> updateAdminPassword(@PathVariable Integer adminId, @PathVariable String newPassword) throws ResourceNotFoundException {
        Admin updatedAdmin = adminService.updateAdminPassword(adminId, newPassword);
        return ResponseEntity.ok(updatedAdmin);
    }
    
	
	@PutMapping("/updateAdminById/{adminId}")
	Admin updateAdminById(@PathVariable ("adminId") Integer adminId, @RequestBody Admin admin) throws ResourceNotFoundException
	{
		return adminService.updateAdminById(adminId,admin);
	}
	@DeleteMapping("/deleteAdminById/{adminId}")
	String deleteAdminById(@PathVariable ("adminId") Integer adminId) throws ResourceNotFoundException
	{
		adminService.deleteAdminById(adminId);
		return "Admin deleted";
	}
	
}

