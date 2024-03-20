package com.example.busbookingsystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.busbookingsystem.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	List<Ticket> findBybusNumber(int passId);
	
}
