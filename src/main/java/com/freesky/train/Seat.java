package com.freesky.train;

import java.util.ArrayList;
import java.util.List;

public class Seat {
	
	private String seatNo;
	
	private List<Ticket> tickets;
	
	public Seat(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public List<Ticket> getTickets() {
		if (null == tickets) {
			tickets = new ArrayList<>();
		}
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Ticket ticket) {
		getTickets().add(ticket);
	}

}
