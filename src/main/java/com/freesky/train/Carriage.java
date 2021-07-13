package com.freesky.train;

import java.util.List;

public class Carriage {
	
	private String carriageNo;
	
	private List<Seat> seats;
	
	public Carriage(String carriageNo) {
		this.carriageNo = carriageNo;
	}

	public String getCarriageNo() {
		return carriageNo;
	}

	public void setCarriageNo(String carriageNo) {
		this.carriageNo = carriageNo;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	
}
