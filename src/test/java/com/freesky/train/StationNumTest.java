package com.freesky.train;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StationNumTest {
	
	
	@Test
	public void test_getName() {
		StationNum s = StationNum.Nanjing;
		String name = s.getName(s.getIndex());
		assertEquals(s.getName(), name);
	}
}
