package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.EmployeeDetails;
@SpringBootTest
public class BindEmployeeServiceTests {

	@MockBean
	private InputStringService inputStringService;
	
	@MockBean
	private ManageEmployeeService manageEmployeeService;
	
	@Autowired
	private BindEmployeeService bindEmployeeService;


	@Test
	void rawEmployees() {
		when(inputStringService.rawString("static//employee.xml")).thenReturn("<?xml version=\"1.0\" encoding=\"UTF-8\"?> "
				+ "<list>"
				+ "<employee>"
				+ "<name>George Smith</name>"
				+ "<department>finance</department>"
				+ "</employee>"
				+ "</list>");
		
		String arr1 [] = new String[1];
		 arr1[0] = "<name>George Smith</name><department>finance</department>";
		 String arr2[] = new String[2];
		 arr2 = bindEmployeeService.rawEmployees();
		assertEquals(arr1[0],arr2[0]);

	}
	
	@Test
	void bindedEmployee() {	
		
		String input = "<name>George Smith</name><department>finance</department>";
		EmployeeDetails employeeDetails1 = new EmployeeDetails();
		String departments[] = {"finance"};
		employeeDetails1
				.setEmployeeFirstName("George")
				.setEmployeeLastName("Smith")
				.setDepartment(departments);
		EmployeeDetails employeeDetails2 = bindEmployeeService.bindEmployee(input);
		assertEquals(employeeDetails1,employeeDetails2);
	}
	
	@Test
	void createSubString() {
		String input = "1234567890";
		String subst = bindEmployeeService.createSubString(input,5 ,input.length());
		assertEquals("67890",subst);
	}
	
	@Test
	void splitElements() {
		String input = "12345 67890";
		String splits[] = bindEmployeeService.splitElements(input," ");
		assertEquals("12345",splits[0]);
		assertEquals("67890",splits[1]);
		assertEquals(2,splits.length);
	}

	@Test
	void filterEmptyString() {		
		String arr1 [] = {"12345","","67890"};
		String filterEmptyString[] = bindEmployeeService.filterEmptyString(arr1);
		assertEquals(2,filterEmptyString.length);
	}
	
	@Test
	void splitDepartments() {
		String department = "<department>finance</department><department>it</department>";
		String departments[] = bindEmployeeService.splitDepartments(department);
		assertEquals("finance",departments[0]);
		assertEquals("it",departments[1]);
		assertEquals(2,departments.length);
	} 
}
