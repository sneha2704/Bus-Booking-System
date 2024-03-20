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

import com.example.busbookingsystem.entity.Ticket;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/ticketBooking")
	public ResponseEntity<Ticket> addTicket(@Valid @RequestBody Ticket ticket) {
		ticket.setTicketId(0);
		return new ResponseEntity<Ticket>(ticketService.saveTicket(ticket), HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/ticketBooking") public ResponseEntity<Ticket>
	 * addTicket(@Valid @RequestBody Ticket ticket) { try { // Save all the details
	 * of the ticket using the ticketService Ticket savedTicket =
	 * ticketService.saveTicket(ticket);
	 * 
	 * // Return the saved ticket along with appropriate HTTP status return new
	 * ResponseEntity<>(savedTicket, HttpStatus.CREATED); } catch (Exception e) { //
	 * Handle any exceptions, such as database errors return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

	@PutMapping("/updateTicket")
	public ResponseEntity<Ticket> updateTicketDetails(@Valid @RequestBody Ticket ticket) {
		Ticket updatedTicket = ticketService.saveTicket(ticket);
		return ResponseEntity.status(HttpStatus.OK).body(updatedTicket);
	}

	@GetMapping("/")
	public List<Ticket> findAll() {
		return ticketService.getAllTickets();
	}

	@GetMapping("/{ticketId}")
	public Ticket findById(@PathVariable int ticketId) throws ResourceNotFoundException {
		return ticketService.getTicketById(ticketId);
	}

	@DeleteMapping("/{ticketId}")
	public String delete(@PathVariable int ticketId) throws ResourceNotFoundException {
		ticketService.deleteTicketById(ticketId);
		return "Deleted ticket Id: " + ticketId;

	}

}
