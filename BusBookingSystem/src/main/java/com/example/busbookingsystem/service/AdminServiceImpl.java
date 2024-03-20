package com.example.busbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.busbookingsystem.entity.Admin;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin registerAdmin( Admin admin) {
		return adminRepository.save(admin);
	}
	
	@Override
	public Admin loginAdmin(String emailId, String password) {
		Admin admin=adminRepository.findAdminByEmailId(emailId);
		if(admin!=null && password.equals(admin.getPassword())) {
		return admin;
		}
		return null;
	}
	
	@Override
	public void deleteAdminById(Integer adminId) throws ResourceNotFoundException {
		Optional<Admin> ad=adminRepository.findById(adminId);
		if(!ad.isPresent()) {
			throw new ResourceNotFoundException("Admin with id "+adminId+" not found");
		}
		adminRepository.deleteById(adminId);
	}
	
	
	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}
	@Override
	public Admin getAdminById(Integer adminId) throws ResourceNotFoundException {
		Optional<Admin> a=adminRepository.findById(adminId);
		Admin a1=null;
		if(!a.isPresent()) {
			throw new ResourceNotFoundException("admin with id "+adminId+" not found");
		}
		a1=adminRepository.findById(adminId).get();
		return a1;
	}
	@Override
	public Admin updateAdminById(Integer adminId, Admin admin) throws ResourceNotFoundException {
		Optional<Admin> a=adminRepository.findById(adminId);
		Admin a1=null;
		if(a.isPresent()) {
			a1=a.get();
			if(admin.getName()!=null) {
				a1.setName(admin.getName());
			}
			if(admin.getEmailId()!=null) {
				a1.setEmailId(admin.getEmailId());
			}
			if(admin.getPassword()!=null) {
				a1.setPassword(admin.getPassword());
			}
		}else {
			throw new ResourceNotFoundException("Admin with id "+adminId+" not found");
		}
		return adminRepository.save(a1);
	}
	@Override
	public Admin getAdminByEmail(String emailId) {
		
		return adminRepository.findAdminByEmailId(emailId);
	}

	@Override
	public Admin updateAdminPassword(Integer adminId, String newPassword) throws ResourceNotFoundException {
		Optional<Admin> optionalAdmin = adminRepository.findById(adminId);

        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setPassword(newPassword);
            return adminRepository.save(admin);
        } else {
            throw new ResourceNotFoundException("Customer with ID " + adminId + " not found");
     
	}
	
	}
}
