package com.bookmymoviesapp.service;

import java.util.List;

import com.bookmymoviesapp.model.Ticket;

public interface TicketService {
	
public List<Ticket> getAllTickets(int mid);
	
	
	public boolean addTicket(Ticket ticket);
	public boolean deleteTicket(int mid);
	public List<Ticket> getAllTickets();


}
