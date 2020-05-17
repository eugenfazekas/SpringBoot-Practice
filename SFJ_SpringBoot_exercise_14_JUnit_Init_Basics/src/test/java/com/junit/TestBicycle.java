package com.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBicycle {

	Bicycle bike = null;
	
	@Before
	public void init () {
		bike = new Bicycle();
	}
	
	@Test
	public void testSum() {
		
		//assertEquals(expected,result)
		assertEquals(3,bike.sum(1,1,1));
		assertEquals(9,bike.sum(2,3,4));
		assertEquals(11,bike.sum(4,3,4));
		assertEquals(1980,bike.sum(2000,-30,10));
	}
}
