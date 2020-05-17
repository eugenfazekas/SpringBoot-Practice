package com.junit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestBicycle {

	Bicycle bike = null;
	
	DataBaseConnection dbCon = Mockito.mock(DataBaseConnection.class);
	
	@Before
	public void init () {
		bike = new Bicycle(dbCon);
	}
	
	@Test
	public void testSum() {
		
		//assertEquals(expected,result)
		assertEquals(3,bike.sum(1,1,1));
		assertEquals(9,bike.sum(2,3,4));
		assertEquals(11,bike.sum(4,3,4));
		assertEquals(1980,bike.sum(2000,-30,10));
	}
	
	@Test
	public void  testSum2() {
		
		when(dbCon.checkUserPass("gyula", "jelszo")).thenReturn(true);
		
		Integer expected = 3;
		assertEquals(expected,bike.sum2("gyula", "jelszo", 1,1,1));
		verify(dbCon).checkUserPass("gyula", "jelszo");
	}
	
}
