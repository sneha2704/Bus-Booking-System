package com.example.busbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.busbookingsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	//@Query(value="select * from Admin where emailId=?",nativeQuery = true)
	Admin findAdminByEmailId(String emailId);

}
