package com.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.model.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.service.MyCommandLineRunner;


@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTests {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private EmployeeService manageEmployeeService;
	@MockBean
	private DepartmentService departmentService;
	@MockBean
	private MyCommandLineRunner myCommandLineRunner;
	
	@Test
	@DisplayName("Testing EmployeeController getEmployees function")
	public void getEmployeesByName() throws Exception {

		when(manageEmployeeService.getEmployees()).thenReturn(new ArrayList<Employee>());
		
		mvc.perform(get("/rest/employees/"))
	            .andExpect(status().isOk());


		verify(manageEmployeeService, times(1)).getEmployees();
	}
	
	@Test
	@DisplayName("Testing EmployeeController getEmployeesByDepartment function")
	public void getEmployeesByDepartment() throws Exception {
		
		when(manageEmployeeService.getEmployees()).thenReturn(new ArrayList<Employee>());
		
		mvc.perform(get("/rest/employees/")
	            .param("department", "it"))
	            .andExpect(status().isOk());

		verify(manageEmployeeService, times(1)).getEmployeesByDepartment("it");

	}

	@Test
	@DisplayName("Testing EmployeeController getDepartmentsWithEmployees function")
	public void getDepartmentsWithEmployees() throws Exception {
		when(manageEmployeeService.getEmployees()).thenReturn(new ArrayList<Employee>());
		
		mvc.perform(get("/rest/employees/groupby/department"))
	          			.andExpect(status().isOk());


		verify(departmentService, times(1)).getDepartmentsWithEmployees();
	}
}
