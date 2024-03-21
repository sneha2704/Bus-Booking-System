package com.example.busbookingsystem.service;

import java.util.List;
import java.util.Optional;

import com.example.busbookingsystem.entity.BusDetails;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;



public interface BusDetailsService {
	
	BusDetails saveBusDetails(BusDetails bus);

	BusDetails getBusByNumber(int busNumber) throws ResourceNotFoundException;

	List<BusDetails> findAll();
	
	void deleteBusByNumber(int busNumber) throws ResourceNotFoundException;
	
	BusDetails updateBusDetails(Optional<BusDetails> busDetails, BusDetails newBusVal);
	
	List<BusDetails> getBusBySourceAndDestination(String source, String destination);

}

