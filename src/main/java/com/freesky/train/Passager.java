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
	
	/**
	 * 火车有多节车厢构成，每节车厢有若干座位，每个座位可以卖出多张车票。
	 * 如何判断乘客购买车票时，某个座位是否可以购买?
	 * 我们需要检查该座位已购的所有车票和乘客打算购买的车票的起始站和终点站。
	 * 如果乘客准备购买的车票的[起始站]落在该座位上任一车票起始站和终点站之间(前闭后开)
	 * 或者乘客准备购买的车票的[终点站]落在该座位上任一车票起始站和终点站之间(前开后闭)
	 * 那么就返回false，告知乘客不能购买该座位。否则，就可以购买。
	 * 
	 * @param tickets   某座位上的所有已购车票
	 * @param starting  准备购买车票的起始站
	 * @param terminal  准备购买车票的终点站
	 * @return   false--不能购买   true--可以购买
	 */
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
