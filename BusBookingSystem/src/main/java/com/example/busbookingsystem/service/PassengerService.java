package com.example.busbookingsystem.service;


import java.util.List;
import com.example.busbookingsystem.entity.Passenger;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;

public interface PassengerService {

	public Passenger registerPassenger(Passenger pass);

	public void deletePassengerById(Integer passId) throws ResourceNotFoundException;

	public List<Passenger> getAllPassenger();

	public Passenger getPassengerById(Integer passId) throws ResourceNotFoundException;

	public Passenger updatePassengerById(Integer passId, Passenger pass) throws ResourceNotFoundException;

	public Passenger getPassengerByEmailId(String emailId);

	public Passenger loginPassenger(String emailId, String password);

	public Passenger updatePassengerPassword(Integer passId, String newPassword) throws ResourceNotFoundException;

}
