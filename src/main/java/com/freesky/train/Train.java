package com.freesky.train;

import java.util.List;

public class Train {
	
	private String trainNo;
	
	private List<Carriage> carriages;
	
	private StationNum starting;
	
	private StationNum terminal;
	
	public Train(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public List<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
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
	

}
