package com.junit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {

	private List testPeople = new List();
	
	@Before
	public void init() {
		testPeople.add("Gyula");
		testPeople.add("Gizi");
	}
	
	@Test
	public void testSize() {
		assertEquals("Meret Ellenorzes",2,testPeople.size());
	}
	
	@Test 
	public void testIsEmpty() {
		assertFalse(testPeople.isEmpty());
	}
	
	@Test
	public void testAdd() {
		testPeople.add("Jani");
		assertEquals("Hozzaadas Ellenorzes",3,3);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void remove() {
		testPeople.remove("Norbi");
	}
	
	@Test
	public void testRemoveAll() {
		testPeople.removeAll();
		assertTrue(testPeople.isEmpty());
	}
	
	@After
	public void destroy() {
		testPeople.removeAll();
		}
}
