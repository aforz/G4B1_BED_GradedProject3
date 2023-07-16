package com.gl.assignment.ticket.service;

import java.util.List;

import com.gl.assignment.ticket.entity.Ticket;

public interface TicketService {

	public List<Ticket> findAll();

	public Ticket findById(int id);

	public void save(Ticket ticket);

	public void deleteById(int id);

	public List<Ticket> findBySearchParameter(String ticketTitle, String ticketShortDescription);

}
