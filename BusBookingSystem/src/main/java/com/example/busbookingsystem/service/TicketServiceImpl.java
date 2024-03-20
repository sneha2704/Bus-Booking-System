package com.example.busbookingsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.busbookingsystem.entity.Ticket;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
/*	@Autowired
    private BusDetailsRepository busDetailsRepository; */


	@Override
	public Ticket saveTicket(Ticket ticket) {

		return ticketRepository.save(ticket);
	} 
	
/*	@Override
    public Ticket saveTicket(Ticket ticket) {
        // Save the ticket
        ticket = ticketRepository.save(ticket);
        
        // Update available seats in the corresponding bus details
        updateAvailableSeats(ticket.getBusNumber(), ticket.getPassCount());
        
        return ticket;
    }
	
	private void updateAvailableSeats(int busNumber, int passCount) {
        // Retrieve the corresponding bus details
        BusDetails busDetails = busDetailsRepository.findBusByBusNumber(busNumber);
        
        // Update available seats
        int currentAvailableSeats = busDetails.getAvailableSeats();
        int updatedAvailableSeats = currentAvailableSeats - passCount;
        busDetails.setAvailableSeats(updatedAvailableSeats);
        
        // Save the updated bus details
        busDetailsRepository.save(busDetails);
    } */

	@Override
	public List<Ticket> getAllTickets() {

		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(int ticketId) throws ResourceNotFoundException {

		return ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket id not found"));
	}

	@Override
	public void deleteTicketById(int ticketId) throws ResourceNotFoundException {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
		} else {
			throw new ResourceNotFoundException("Ticket Id not found: " + ticketId);

		}

	}

	@Override
	public List<Ticket> getAllTicketsByPassengerId(int passId) {

		return ticketRepository.findBybusNumber(passId);
	}

}
