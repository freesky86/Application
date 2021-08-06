package com.freesky.train;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Journey {
	
	private static Logger logger = Logger.getLogger(Journey.class);
	
	private Passager passager;
	private Train train;
	
	
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public static void main(String[] args) {
		logger.info("--begin to initialize Journey class.");
		
		Journey journey = new Journey();
		
		journey.initialize();
		
//		journey.buyTicket(StationNum.Shanghai, StationNum.Nanjing);
//		journey.buyTicket(StationNum.Suzhou, StationNum.Nanjing);
//		journey.buyTicket(StationNum.Nanjing, StationNum.Jinan);
//		journey.buyTicket(StationNum.Shijiazhuang, StationNum.Beijing);
//		journey.buyTicket(StationNum.Jinan, StationNum.Shijiazhuang);
		
		journey.buyTicket(StationNum.Suzhou, StationNum.Nanjing);
		journey.buyTicket(StationNum.Shanghai, StationNum.Suzhou);
	}
	
	public void buyTicket(StationNum starting, StationNum terminal) {
		Ticket ticket = passager.buyTicket(starting, terminal, train);
		if (null == ticket) {
			System.out.println("Failed to buy ticket :(");
		} else {
			System.out.println("Buy ticket Successfully!");
		}
		
		List<Ticket> tickets = train.getCarriages().get(0).getSeats().get(0).getTickets();
		for (Ticket t : tickets) {
			System.out.println(t.toString());
		}
		
		System.out.println();
	}
	
	public void initialize() {
		Train train = new Train("G2101");
		this.setTrain(train);

		Passager passager = new Passager("123", "Max");
		this.setPassager(passager);
		
		
		train.setStarting(StationNum.Shanghai);
		train.setTerminal(StationNum.Beijing);
		List<Carriage> carriages = new ArrayList<>();
		Carriage carriage = new Carriage("C01");
		List<Seat> seats = new ArrayList<>();
		Seat seat = new Seat("A1");
		seats.add(seat);
		carriage.setSeats(seats);
		carriages.add(carriage);
		train.setCarriages(carriages);
	}

}
