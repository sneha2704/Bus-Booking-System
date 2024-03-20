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
import com.example.busbookingsystem.entity.Passenger;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.service.PassengerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/passengers")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	
	private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@PostMapping("/registerPassenger")
	public ResponseEntity<Passenger> registerPassenger(@Valid @RequestBody Passenger pass) {
		logger.info("Received request to register passenger: {}", pass);
		Passenger pass1 = passengerService.registerPassenger(pass);
		  logger.info("Passenger registered successfully: {}", pass1);
		return new ResponseEntity<Passenger>(pass1, HttpStatus.CREATED);
	}
		

	// login passenger using email and password
	@GetMapping("/loginPassenger/{emailId}/{password}")
	public Passenger loginPassenger(@PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		 logger.info("Received login request for email: {}", emailId);
	        // Add more logging as needed
		// Call the service method to perform login
	        Passenger loggedInPassenger = passengerService.loginPassenger(emailId, password);

	        // Log the result of the login attempt
	        if (loggedInPassenger != null) {
	            logger.info("Login successful for email: {}", emailId);
	        } else {
	            logger.error("Login failed for email: {}", emailId);
	        }

	        return loggedInPassenger;
	    }
	

	@GetMapping("/getAllPassengers")
	List<Passenger> getAllPassenger() {
		return passengerService.getAllPassenger();
	}

	@GetMapping("/getPassengerById/{passId}")
	public Passenger getPassengerById(@PathVariable("passId") Integer passId) throws ResourceNotFoundException {
		return passengerService.getPassengerById(passId);
	}

	@GetMapping("/getPassengerByEmailId/{emailId}")
	public Passenger getPassengerByEmail(@PathVariable("emailId") String emailId) {
		return passengerService.getPassengerByEmailId(emailId);
	}

	@PutMapping("/updateAPassengerPassword/{passId}/{newPassword}")
	public ResponseEntity<Passenger> updatePassengerPassword(@PathVariable Integer passId,
			@PathVariable String newPassword) throws ResourceNotFoundException {
		Passenger updatedPassenger = passengerService.updatePassengerPassword(passId, newPassword);
		return ResponseEntity.ok(updatedPassenger);
	}

	@PutMapping("/updatePassengerById/{passId}")
	Passenger updatePassengerById(@PathVariable("passId") Integer passId, @RequestBody Passenger pass)
			throws ResourceNotFoundException {
		return passengerService.updatePassengerById(passId, pass);
	}

	@DeleteMapping("/deletePassengerById/{passId}")
	String deletePassengerById(@PathVariable("passId") Integer passId) throws ResourceNotFoundException {
		passengerService.deletePassengerById(passId);
		return "Passenger deleted" + passId;
	}

	

}
