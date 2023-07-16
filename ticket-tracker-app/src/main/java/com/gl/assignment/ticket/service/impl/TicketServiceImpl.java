package com.gl.assignment.ticket.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.assignment.ticket.entity.Ticket;
import com.gl.assignment.ticket.repository.TicketRepository;
import com.gl.assignment.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets;
	}

	@Override
	public Ticket findById(int id) {
		Optional<Ticket> tickFromDB = ticketRepository.findById(id);
		Ticket ticket = null;
		if (tickFromDB.isPresent()) {
			ticket = tickFromDB.get();
		} else {
			throw new RuntimeException("Ticket doesn't exist: " + id);
		}
		return ticket;
	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> findBySearchParameter(String ticketTitle, String ticketDescription) {
		List<Ticket> tickets = ticketRepository
				.findByTicketTitleIgnoreCaseContainingOrTicketShortDescriptionIgnoreCaseContaining(ticketTitle,
						ticketDescription);
		return tickets;
	}

}
