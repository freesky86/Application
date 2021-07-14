package com.freesky.train;

import java.util.List;

public class Passager {
	
	private String id;
	private String name;
	
	private Ticket ticket;
	
	public Passager(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Ticket buyTicket(StationNum starting, StationNum terminal, Train train) {
		if (starting.getIndex() >= terminal.getIndex()) {
			System.out.println("This is not a valid journey from " + starting.getName() + " to " + terminal.getName());
			return null;
		}
		
		Seat seat = train.getCarriages().get(0).getSeats().get(0);
		List<Ticket> tickets = seat.getTickets();
		Ticket ticket = null;
		if (tickets.isEmpty()) {
			ticket = generateTicket(starting, terminal);
		} else {
			boolean isValid = checkTicket(tickets, starting, terminal);
			if (isValid) {
				ticket = generateTicket(starting, terminal);
			}
		}
		
		if (null != ticket) {
			seat.addTicket(ticket);
		}
		this.setTicket(ticket);
		
		return ticket;
	}
	
	protected boolean checkTicket(List<Ticket> tickets, StationNum starting, StationNum terminal) {
		for (Ticket ticket : tickets) {
			StationNum start = ticket.getStarting();
			StationNum end = ticket.getTerminal();
			// starting [ )
			if (starting.getIndex() >= start.getIndex() && starting.getIndex() < end.getIndex()) {
				return false;
			}
			// terminal ( ]
			if (terminal.getIndex() > start.getIndex() && terminal.getIndex() <= end.getIndex()) {
				return false;
			}
		}
		
		return true;
	}
	
	protected Ticket generateTicket(StationNum starting, StationNum terminal) {
		Ticket ticket = new Ticket("T" + System.currentTimeMillis());
		ticket.setStarting(starting);
		ticket.setTerminal(terminal);
		
		return ticket;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	
}
