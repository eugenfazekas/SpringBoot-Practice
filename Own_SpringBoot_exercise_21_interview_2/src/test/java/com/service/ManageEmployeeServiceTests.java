package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Department;
import com.model.Employee;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.EmployeeFirstNameComparator;

@SpringBootTest
public class ManageEmployeeServiceTests {
	
	@Autowired
	private ManageEmployeeService manageEmployeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	private List<Employee> employees;
	private List<Department> deparments;
	private List<String> deparmentsName;
	private EmployeeDetails employeeDetails;
	
	@Test
	@DisplayName("Testing ManageEmployeeService addEmployee1 functions")
	void addEmployee1() {
		
	    String department1[] = {"it"};
			    employeeDetails = new EmployeeDetails();
			    employeeDetails.setFirstName("John");
			    employeeDetails.setLastName("Krugger");
			    employeeDetails.setDepartment(department1);
		
		when(employeeRepository.employeeDetailsExistCheck(employeeDetails,"it")).thenReturn(0);
		when(employeeRepository.registerEmployee(employeeDetails,"it")).thenReturn("EMPLOYEEDETAILS Registered");
		
		assertEquals("EMPLOYEEDETAILS Registered", manageEmployeeService.registerEmployee(employeeDetails));
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService addEmployee2 functions with null return value")
	void addEmployee2() {
		
	    String department1[] = {"it"};
	    employeeDetails = new EmployeeDetails();
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartment(department1);

when(employeeRepository.employeeDetailsExistCheck(employeeDetails,"it")).thenReturn(1);
when(employeeRepository.registerEmployee(employeeDetails,"it")).thenReturn("EMPLOYEEDETAILS Registered");
		
		assertEquals(null, manageEmployeeService.registerEmployee(employeeDetails));
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService employeeExist functions whit employee not been added until now")
	void employeeExist1() {		
		
	    String department1[] = {"it"};
	    employeeDetails = new EmployeeDetails();
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartment(department1);
	    	
	    when(employeeRepository.employeeDetailsExistCheck(employeeDetails,"it")).thenReturn(0);
		
		assertEquals(0, manageEmployeeService.employeeExist(employeeDetails));
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService employeeExist functions whit already added employee")
	void employeeExist2() {	
		
	    String department1[] = {"it"};
	    employeeDetails = new EmployeeDetails();
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger")
	        .setDepartment(department1);

	    when(employeeRepository.employeeDetailsExistCheck(employeeDetails,"it")).thenReturn(1);
		
		assertEquals(1, manageEmployeeService.employeeExist(employeeDetails));
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService getEmployees functions")
	void getEmployees() {
		
	    employees = new ArrayList<Employee>();
	    
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    
	    Employee employee2 = new Employee();
	    employee2.setFirstName("John");
	    employee2.setLastName("Travolta");
	    
	    
	    employees.add(employee1);
	    employees.add(employee2);
	        
		Collections.sort(employees, new EmployeeFirstNameComparator());
	    
		when(employeeRepository.getEmployees()).thenReturn(employees);
		
		assertEquals(employees, manageEmployeeService.getEmployees());
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService getEmployeesByDepartment functions")
	void getEmployeesByDepartment() {
		
	    employees = new ArrayList<Employee>();
    
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    
	    Employee employee2 = new Employee();
	    employee2.setFirstName("John");
	    employee2.setLastName("Travolta");

	    employees.add(employee1);
	    employees.add(employee2);
    
		Collections.sort(employees, new EmployeeFirstNameComparator());
	    
		when(employeeRepository.getEmployeesByDepartment("it")).thenReturn(employees);
		
		assertEquals(employees, manageEmployeeService.getEmployeesByDepartment("it"));

	}
	

	@Test
	@DisplayName("Testing ManageEmployeeService createDepartment functions")
	void createDepartment() {
		
	    employees = new ArrayList<Employee>();
	
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    
	    Employee employee2 = new Employee();
	    employee2.setFirstName("John");
	    employee2.setLastName("Travolta");

	    employees.add(employee1);
	    employees.add(employee2);
    
		Collections.sort(employees, new EmployeeFirstNameComparator());
		
		Department department = new Department("it",employees);
		
		when(employeeRepository.getEmployeesByDepartment("it")).thenReturn(employees);
		
		assertEquals(department, manageEmployeeService.createDepartment("it"));
	}

	@Test
	@DisplayName("Testing ManageEmployeeService getDepartmentsWithEmployees functions")
	void getDepartmentsWithEmployees() {
		 employees = new ArrayList<Employee>();
		 
		    Employee employee1 = new Employee();
		    employee1.setFirstName("John");
		    employee1.setLastName("Krugger");
		    
		    Employee employee2 = new Employee();
		    employee2.setFirstName("John");
		    employee2.setLastName("Travolta");
		    
		    Employee employee3 = new Employee();
		    employee3.setFirstName("Kabat");
		    employee3.setLastName("Peti");
		    
		    Employee employee4 = new Employee();
		    employee4.setFirstName("Nagy");
		    employee4.setLastName("Adam");
		    
		    employees.add(employee1);
		    employees.add(employee2);
		    employees.add(employee3);
		    employees.add(employee4);
		    
			Collections.sort(employees, new EmployeeFirstNameComparator());
			
			List<String> departmentsName = new ArrayList<String>();
			departmentsName.add("it");
			
			Department department = new Department("it",employees);
			deparments = new ArrayList<>();
			deparments.add(department);
	
    when(employeeRepository.getDepartments()).thenReturn(departmentsName);	    
	when(employeeRepository.getEmployeesByDepartment("it")).thenReturn(employees);
	
	assertEquals(deparments, manageEmployeeService.getDepartmentsWithEmployees());

	}	

}
