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

import com.example.busbookingsystem.entity.BusDetails;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.service.BusDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/BusDetails")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class BusDetailsController {
	
	@Autowired
	private BusDetailsService  busService;
	
	@PostMapping("/savebus")
	public ResponseEntity<BusDetails> saveBusDetails(@Valid @RequestBody BusDetails bus) {
		bus.setBusNumber(0);
		return new ResponseEntity<BusDetails>(busService.saveBusDetails(bus),HttpStatus.CREATED);
	}
	
	@GetMapping("/{busNumber}")
	public BusDetails getBusByNumber(@PathVariable int busNumber) throws ResourceNotFoundException {
		return busService.getBusByNumber(busNumber);
		
	}
	
	
	@GetMapping("/Allbuses")
	public List<BusDetails> findAll() {
		return busService.findAll();
		
	}
	
	@DeleteMapping("/delete/{busNumber}")
	public String deleteBusByNumber(@PathVariable int busNumber) throws ResourceNotFoundException {
		busService.deleteBusByNumber(busNumber);
		return "Deleted Bus Number: "+busNumber;	
	}
	
	@PutMapping("/updateBus")
	public ResponseEntity<BusDetails> updateBusDetails(@Valid @RequestBody BusDetails bus) {
		BusDetails updatedBus = busService.saveBusDetails(bus);
		return ResponseEntity.status(HttpStatus.OK).body(updatedBus);
	}


	@GetMapping("/{source}/{destination}")
	public List<BusDetails> getBusBySourceAndDestination(@PathVariable String source,@PathVariable String destination){
		return busService.getBusBySourceAndDestination(source, destination);
		
	}
}
