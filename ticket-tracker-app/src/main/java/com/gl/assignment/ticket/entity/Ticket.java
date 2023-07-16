package com.gl.assignment.ticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ticket_title")
	private String ticketTitle;

	@Column(name = "ticket_short_description")
	private String ticketShortDescription;

	@CreationTimestamp
	@Column(name = "ticket_created_on")
	private LocalDate ticketCreatedOn = LocalDate.now();

	@Column(name = "content")
	private String content;

}
