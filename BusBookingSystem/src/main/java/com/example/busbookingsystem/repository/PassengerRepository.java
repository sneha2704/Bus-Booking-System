package com.example.busbookingsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.busbookingsystem.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	//@Query(value="select * from Passenger where emailId=?",nativeQuery = true)
	
	Passenger findPassengerByEmailId(String emailId);
	
}
