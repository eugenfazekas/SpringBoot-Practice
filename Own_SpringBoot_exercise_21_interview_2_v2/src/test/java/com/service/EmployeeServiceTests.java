package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Employee;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.EmployeeFirstNameComparator;

@SpringBootTest
public class EmployeeServiceTests {

	@Autowired
	private EmployeeService manageEmployeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@MockBean
	private MyCommandLineRunner myCommandLineRunner;
	
	private List<EmployeeDetails> employees;

	private EmployeeDetails employeeDetails;
	
	@Test
	@DisplayName("Testing EmployeeService addEmployee1 functions")
	void addEmployee1() {
		
		when(employeeRepository.getEmployeeDetails()).thenReturn(new ArrayList<EmployeeDetails>());
		when(employeeRepository.addEmployee(new EmployeeDetails())).thenReturn("addEmployees");
		
		assertEquals("User added", manageEmployeeService.addEmployee(new EmployeeDetails()));
	}
	
	@Test
	@DisplayName("Testing EmployeeService addEmployee3 functions")
	void addEmployee3() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    String deparments1[] = {"it"};     
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartments(deparments1);
	    
	    String deparments2[] = {"finance"};      
	    EmployeeDetails employeeDetails2 = new EmployeeDetails();
	    employeeDetails2.setFirstName("John");
	    employeeDetails2.setLastName("Krugger");
	    employeeDetails2.setDepartments(deparments2);
	    
	    employees.add(employeeDetails);
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals("department added to user", manageEmployeeService.addEmployee(employeeDetails2));
	}
	

	
	@Test
	@DisplayName("Testing EmployeeService employeeExist functions whit employee not been added until now")
	void employeeExist1() {		
		
	    employees = new ArrayList<EmployeeDetails>();
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(-1, manageEmployeeService.employeeExist(new EmployeeDetails()));
	}
	
	@Test
	@DisplayName("Testing EmployeeService employeeExist functions whit already added employee")
	void employeeExist2() {	
				
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    
	    employees.add(employeeDetails);
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(0, manageEmployeeService.employeeExist(employeeDetails));
	}
	

	
	@Test
	@DisplayName("Testing EmployeeService getEmployees function")
	void getEmployees() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartments(null);
	    
	    EmployeeDetails employeeDetails2 = new EmployeeDetails();
	    employeeDetails2.setFirstName("John");
	    employeeDetails2.setLastName("Travolta");
	    employeeDetails2.setDepartments(null);
	    
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    
	    Employee employee2 = new Employee();
	    employee2.setFirstName("John");
	    employee2.setLastName("Travolta");
	    
	    
	    employees.add(employeeDetails);
	    employees.add(employeeDetails2);
	    
	    List<Employee> e = new ArrayList<Employee>();
	    e.add(employee1);
	    e.add(employee2);
	    
		Collections.sort(e, new EmployeeFirstNameComparator());
	    
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(e, manageEmployeeService.getEmployees());
	}
	
	@Test
	@DisplayName("Testing EmployeeService getEmployeesByDepartment function")
	void getEmployeesByDepartment() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    String department1[] = {"it"};
	    String department2[] = {"finance"};
	    
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartments(department1);
	    
	    EmployeeDetails employeeDetails2 = new EmployeeDetails();

	    employeeDetails2.setFirstName("John");
	    employeeDetails2.setLastName("Travolta");
	    employeeDetails2.setDepartments(department2);
	    
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    	    
	    employees.add(employeeDetails);
	    employees.add(employeeDetails2);
	    
	    List<Employee> e = new ArrayList<Employee>();
	    e.add(employee1);
    
		Collections.sort(e, new EmployeeFirstNameComparator());
	    
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(e, manageEmployeeService.getEmployeesByDepartment("it"));

	}
}