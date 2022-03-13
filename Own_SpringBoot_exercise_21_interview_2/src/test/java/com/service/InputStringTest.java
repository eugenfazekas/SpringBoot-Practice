package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InputStringTest {
	
	@Autowired
	private InputStringService inputStringService;

	@Test
	@DisplayName("Testing InputStringService readFromInputStream function")
	void readFromInputStream1() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("static//employee_test.xml");
		
		String data_readed = inputStringService.readFromInputStream(inputStream);
		String expcted = "\ufeff<?xml version=\"1.0\" encoding=\"UTF-8\"?><list><employee><name>George Smith</name><department>finance</department></employee></list>";
		//String a = String.format("\\u%04x", (int)data_readed.charAt(0));

		assertEquals(expcted,data_readed);
	}
	
	@Test
	@DisplayName("Testing InputStringService readFromInputStream function with invalid path")
	void readFromInputStream2() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("static//employee_test2.xml");
		
		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
			String data_readed = inputStringService.readFromInputStream(inputStream);
	  });

		  Assertions.assertEquals(null, thrown.getMessage());
	}
	
	@Test
	@DisplayName("Testing InputStringService rawString function")
	void rawString() {	
		String data_readed  =  inputStringService.rawString("static//employee_test.xml");
		String expcted = "\ufeff<?xml version=\"1.0\" encoding=\"UTF-8\"?><list><employee><name>George Smith</name><department>finance</department></employee></list>";
		assertEquals(expcted,data_readed);
	}
}
