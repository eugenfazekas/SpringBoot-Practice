package com.integrationtests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Employee;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTests {

	@Autowired
    private MockMvc mvc;
	

	
	String getEmployees() throws JsonProcessingException {
			
		List<String> list= new ArrayList<>(); 
		
		ObjectMapper mapper = new ObjectMapper(); 
		Employee employee1 = new Employee();
		employee1.setFirstName("Dale");
		employee1.setLastName("Miller");
		
		
		String simpleJSON = mapper.writeValueAsString(employee1); 
		list.add(simpleJSON);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("James");
		employee2.setLastName("Doyle");
		
		simpleJSON = mapper.writeValueAsString(employee2); 
		list.add(simpleJSON);
		
		String newsLetterJSON = mapper.writeValueAsString(list); 
		
		return newsLetterJSON;
	}

	

	@Test
	@DisplayName("Integration test to read the xml file")
	void initFileRead () throws Exception {
		mvc.perform(get("/rest/employees/")
		.param("department", "packaging"))
	    .andExpect(status().isOk())
	    .andExpect(jsonPath("$.[0].firstName", is("Dale")))
	    .andExpect(jsonPath("$.[1].firstName", is("James")));
	}
}
