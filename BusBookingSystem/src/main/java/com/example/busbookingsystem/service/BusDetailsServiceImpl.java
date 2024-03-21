package com.example.busbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busbookingsystem.entity.BusDetails;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.repository.BusDetailsRepository;


@Service
public class BusDetailsServiceImpl implements BusDetailsService {

	@Autowired
	private BusDetailsRepository busRepository;
	
	@Override
	public BusDetails saveBusDetails(BusDetails bus) {
		
		return busRepository.save(bus);
	}

/*	@Override
	public BusDetails getBusByNumber(int busNumber) throws ResourceNotFoundException {
		Optional<BusDetails> result = busRepository.findById(busNumber);
		BusDetails bus;
		if (result.isPresent()) {
			bus = result.get();
		} else {
			throw new ResourceNotFoundException("Bus Id not found: " + busNumber);
		}
		return bus;
	} */

	

	
	
	@Override
	public List<BusDetails> findAll() {
		
		return busRepository.findAll();
	}

	@Override
	public void deleteBusByNumber(int busNumber) throws ResourceNotFoundException {
		if (busRepository.existsById(busNumber)) {
			busRepository.deleteById(busNumber);
		} 
		else {
			throw new ResourceNotFoundException("Bus number not found: " + busNumber);

	}
		
	}

	@Override
	public BusDetails updateBusDetails(Optional<BusDetails> busDetails, BusDetails newBusVal) {
		BusDetails bus = busDetails.get();
		bus.setJourneyDate(newBusVal.getJourneyDate());
		bus.setJourneyTime(newBusVal.getJourneyTime());
		bus.setTotalSeats(newBusVal.getTotalSeats());
		bus.setAvailableSeats(newBusVal.getAvailableSeats());
		bus.setSource(newBusVal.getSource());
		bus.setDestination(newBusVal.getDestination());
		bus.setTicketPrice(newBusVal.getTicketPrice());
		
		return busRepository.save(bus);
	}

	@Override
	public List<BusDetails> getBusBySourceAndDestination(String source, String destination) {
	
		return busRepository.findBySourceAndDestination(source, destination);
	}

	@Override
	public BusDetails getBusByNumber(int busNumber) throws ResourceNotFoundException {
		return busRepository.findBusByBusNumber(busNumber);
		
	}

}
