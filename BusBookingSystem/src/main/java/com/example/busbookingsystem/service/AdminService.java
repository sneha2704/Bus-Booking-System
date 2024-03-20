package com.example.busbookingsystem.service;

import java.util.List;
import com.example.busbookingsystem.entity.Admin;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;

public interface AdminService {

	public Admin registerAdmin(Admin admin);

	public void deleteAdminById(Integer adminId) throws ResourceNotFoundException;

	public List<Admin> getAllAdmin();

	public Admin getAdminById(Integer adminId) throws ResourceNotFoundException;

	public Admin updateAdminById(Integer adminId, Admin admin) throws ResourceNotFoundException;

	public Admin getAdminByEmail(String emailId);

	public Admin loginAdmin(String emailId, String password);

	public Admin updateAdminPassword(Integer adminId, String newPassword) throws ResourceNotFoundException;
}
