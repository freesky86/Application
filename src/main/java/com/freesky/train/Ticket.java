package com.freesky.train;

public class Ticket {
	
	private String ticketNo;
	
	private StationNum starting;
	
	private StationNum terminal;
	
	public Ticket(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public StationNum getStarting() {
		return starting;
	}

	public void setStarting(StationNum starting) {
		this.starting = starting;
	}

	public StationNum getTerminal() {
		return terminal;
	}

	public void setTerminal(StationNum terminal) {
		this.terminal = terminal;
	}
	
	@Override
	public String toString() {
		return "From " + this.starting.getName() + " to " + this.terminal.getName();
	}

}
