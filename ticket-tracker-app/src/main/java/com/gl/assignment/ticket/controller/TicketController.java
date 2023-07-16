package com.gl.assignment.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.assignment.ticket.entity.Ticket;
import com.gl.assignment.ticket.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/list")
	public String listTickets(Model theModel) {
		List<Ticket> tickets = ticketService.findAll();
		theModel.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/create")
	public String createTicket(Model theModel) {
		Ticket ticket = new Ticket();
		String heading = "Create Ticket";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("ticket", ticket);
		return "tickets/ticket-form";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/tickets/list";
	}

	@PostMapping("/edit")
	public String editTicket(@RequestParam("id") int id, Model theModel) {
		Ticket ticket = ticketService.findById(id);
		String heading = "Edit Ticket";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("ticket", ticket);
		return "tickets/ticket-form";
	}

	@GetMapping("/delete")
	public String deleteTicket(@RequestParam("id") int id) {
		ticketService.deleteById(id);
		return "redirect:/tickets/list";
	}

	@GetMapping("/search")
	public String searchTicket(@RequestParam("searchParameter") String searchParameter, Model theModel) {
		List<Ticket> tickets = ticketService.findBySearchParameter(searchParameter, searchParameter);
		theModel.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/view")
	public String viewTicket(@RequestParam("id") int id, Model theModel) {
		Ticket ticket = ticketService.findById(id);
		String heading = "View Ticket";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("ticket", ticket);
		return "tickets/ticket-view";
	}

}
