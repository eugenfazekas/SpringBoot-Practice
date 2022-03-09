package com.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class InputStringService {
			
	public InputStringService() {}
	
	public String readFromInputStream(InputStream inputStream) throws IOException {
	    StringBuilder resultStringBuilder = new StringBuilder();
	    try (BufferedReader br
	      = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            resultStringBuilder.append(line).append("");
	        }
	    }
	    		return resultStringBuilder.toString();
	}

	public String rawString() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("static//employee.xml");		
		String data = "";
			try {
			data = readFromInputStream(inputStream);
			} catch(IOException e) {
				System.out.println("File Read failed: "+ e);
			}		
			return data;
	}
}