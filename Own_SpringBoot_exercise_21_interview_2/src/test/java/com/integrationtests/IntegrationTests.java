package com.integrationtests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTests {

	@Autowired
    private MockMvc mvc;

	@Test
	@DisplayName("Integration test to read the xml file")
	void initFileRead () throws Exception {
		mvc.perform(get("/rest/employees/initFileRead"))
	    .andExpect(status().isOk())
	    .andExpect(content().string(String.valueOf(7)));
	}
}
