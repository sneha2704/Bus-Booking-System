package com.example.busbookingsystem.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.busbookingsystem.entity.Passenger;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.repository.PassengerRepository;


@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public Passenger registerPassenger( Passenger pass) {
		return passengerRepository.save(pass);
	}
	
	@Override
	public Passenger loginPassenger(String emailId, String password) {
		Passenger pass=passengerRepository.findPassengerByEmailId(emailId);
		if(pass!=null && password.equals(pass.getPassword())) {
		return pass;
		}
		return null;
	}
	
	@Override
	public void deletePassengerById(Integer passId) throws ResourceNotFoundException {
		Optional<Passenger> ad=passengerRepository.findById(passId);
		if(!ad.isPresent()) {
			throw new ResourceNotFoundException("Passenger with id "+passId+" not found");
		}
		passengerRepository.deleteById(passId);
	}
	
	
	@Override
	public List<Passenger> getAllPassenger() {
		return passengerRepository.findAll();
	}
	
	@Override
	public Passenger getPassengerById(Integer passId) throws ResourceNotFoundException {
		Optional<Passenger> p =passengerRepository.findById(passId);
		Passenger p1=null;
		if(!p.isPresent()) {
			throw new ResourceNotFoundException("Passenger with id "+passId+" not found");
		}
		p1=passengerRepository.findById(passId).get();
		return p1;
	}
	
	@Override
	public Passenger updatePassengerById(Integer passId, Passenger pass) throws ResourceNotFoundException {
		Optional<Passenger> p =passengerRepository.findById(passId);
		Passenger p1=null;
		if(p.isPresent()) {
			p1=p.get();
			if(pass.getPassName()!=null) {
				p1.setPassName(pass.getPassName());
			}
			if(pass.getEmailId()!=null) {
				p1.setEmailId(pass.getEmailId());
			}
			if(pass.getPassword()!=null) {
				p1.setPassword(pass.getPassword());
			}
		}else {
			throw new ResourceNotFoundException("Passenger with id "+passId+" not found");
		}
		return passengerRepository.save(p1);
	}
	
	@Override
	public Passenger getPassengerByEmailId(String emailId) {
		
		return passengerRepository.findPassengerByEmailId(emailId);
	}

	@Override
	public Passenger updatePassengerPassword(Integer passId, String newPassword) throws ResourceNotFoundException {
		Optional<Passenger> optionalPassenger = passengerRepository.findById(passId);

        if (optionalPassenger.isPresent()) {
            Passenger pass = optionalPassenger.get();
            pass.setPassword(newPassword);
            return passengerRepository.save(pass);
        } else {
            throw new ResourceNotFoundException("Passenger with Id" + passId + " not found");
     
	}
	
	}

}
