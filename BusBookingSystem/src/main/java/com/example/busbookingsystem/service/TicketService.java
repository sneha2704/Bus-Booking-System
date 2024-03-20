package com.example.busbookingsystem.service;

import java.util.List;
import com.example.busbookingsystem.entity.Ticket;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;


public interface TicketService {
	
	Ticket saveTicket(Ticket ticket);
	
	List<Ticket> getAllTickets();
	
	Ticket getTicketById(int ticketId)throws ResourceNotFoundException;
	
	void deleteTicketById(int ticketId) throws ResourceNotFoundException;
	
	public List<Ticket> getAllTicketsByPassengerId(int passId);

	
	
}
