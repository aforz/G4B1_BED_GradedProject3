package com.gl.assignment.ticket.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.gl.assignment.ticket.entity.Ticket;
import com.gl.assignment.ticket.repository.TicketRepository;

@Configuration
public class BootstrapAppData {

	@Autowired
	private TicketRepository ticketRepository;

	private Faker faker = new Faker();

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady(ApplicationReadyEvent event) {

		for (int i = 0; i < 5; i++) {
			Ticket ticket = new Ticket();

			ticket.setTicketTitle(faker.rockBand().name());
			ticket.setTicketShortDescription(faker.artist().name().describeConstable().get());
			ticket.setContent(faker.avatar().image());

			this.ticketRepository.saveAndFlush(ticket);
		}

	}
}
