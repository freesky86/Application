package com.freesky.train;

public enum StationNum {

	Shanghai("Shanghai", 1), Suzhou("Suzhou", 2), Wuxi("Wuxi", 3), Changzhou("Changzhou", 4), 
	Nanjing("Nanjing", 5), Jinan("Jinan", 6), Shijiazhuang("Shijiazhuang", 7), Beijing("Beijing", 8);
	
	private String name;
	
	private int index;
	

	private StationNum(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public String getName(int index) {
		for (StationNum s : StationNum.values()) {
			if (s.getIndex() == index) {
				return s.getName();
			}
		}
		return null;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}

}
