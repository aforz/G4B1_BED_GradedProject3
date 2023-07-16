package com.gl.assignment.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.assignment.ticket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	List<Ticket> findByTicketTitleIgnoreCaseContainingOrTicketShortDescriptionIgnoreCaseContaining(String ticketTitle,
			String ticketDescription);

}
