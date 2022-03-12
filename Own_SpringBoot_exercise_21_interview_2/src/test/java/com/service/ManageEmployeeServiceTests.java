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
	
	private List<EmployeeDetails> employees;
	private List<Department> deparments;
	private EmployeeDetails employeeDetails;
	
	@Test
	@DisplayName("Testing ManageEmployeeService addEmployee1 functions")
	void addEmployee1() {
		
		when(employeeRepository.getEmployeeDetails()).thenReturn(new ArrayList<EmployeeDetails>());
		when(employeeRepository.addEmployee(new EmployeeDetails())).thenReturn("addEmployees");
		
		assertEquals("addEmployees", manageEmployeeService.addEmployee(new EmployeeDetails()));
	}
	
	@Test
	@DisplayName("Testing ManageEmployeeService addEmployee2 functions")
	void addEmployee2() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger");
	    
	    employees.add(employeeDetails);
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(null, manageEmployeeService.addEmployee(employeeDetails));
	}
	
	@Test
	void initDepartments1() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    deparments = new ArrayList<Department>();
	    employeeDetails = new EmployeeDetails();
	    
	    String department[] = {"it"};
	    
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger")
	    	.setDepartment(department);
	    
	    employees.add(employeeDetails);
	    
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(1, manageEmployeeService.initDepartments());
	}
	
	@Test
	void initDepartments2() {
		
	    employees = new ArrayList<EmployeeDetails>();

		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);		
		
		assertEquals(0, manageEmployeeService.initDepartments());
	}
	
	@Test
	void addDepartment1() {
		
	    deparments = new ArrayList<Department>();
		
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		when(employeeRepository.addDepartment(new Department("it"))).thenReturn("addDepartment");
		assertEquals("addDepartment", manageEmployeeService.addDepartment("it"));
	}
	
	@Test
	void addDepartment2() {

	    deparments = new ArrayList<Department>();
	    deparments.add(new Department("it"));
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		when(employeeRepository.addDepartment(new Department("it"))).thenReturn("addDepartment");
		
		assertEquals(null, manageEmployeeService.addDepartment("it"));
	}
	
	@Test
	void employeeExist1() {		
		
	    employees = new ArrayList<EmployeeDetails>();
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(0, manageEmployeeService.employeeExist(new EmployeeDetails()));
	}
	
	@Test
	void employeeExist2() {	
				
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger");
	    
	    employees.add(employeeDetails);
	    	
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		
		assertEquals(1, manageEmployeeService.employeeExist(employeeDetails));
	}
	
	@Test
	void departmentExist1() {		

	    deparments = new ArrayList<Department>();
	    	
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(0, manageEmployeeService.departmentExist("it"));
		
	}
	
	@Test
	void departmentExist2() {		

	    deparments = new ArrayList<Department>();
	    deparments.add(new Department("it"));
	    	
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(1, manageEmployeeService.departmentExist("it"));
	}
	
	@Test
	void getEmployees() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger")
	    	.setDepartment(null);
	    
	    EmployeeDetails employeeDetails2 = new EmployeeDetails();
	    employeeDetails2
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Travolta")
	    	.setDepartment(null);
	    
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
	void getEmployeesByDepartment() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    employeeDetails = new EmployeeDetails();
	    String department1[] = {"it"};
	    String department2[] = {"finance"};
	    
	    employeeDetails
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Krugger")
	    	.setDepartment(department1);
	    
	    EmployeeDetails employeeDetails2 = new EmployeeDetails();
	    employeeDetails2
	    	.setEmployeeFirstName("John")
	    	.setEmployeeLastName("Travolta")
	    	.setDepartment(department2);
	    
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
	
	@Test
	void getDepartmentsWithEmployees() {
		 employees = new ArrayList<EmployeeDetails>();
		 
		    String ddepartment1[] = {"it"};
		    String ddepartment2[] = {"finance"};
		    		 
		    EmployeeDetails employeeDetails1 = new EmployeeDetails();
		    employeeDetails1.setFirstName("John");
		    employeeDetails1.setLastName("Krugger");
		    employeeDetails1.setDepartment(ddepartment1);
		    
		    EmployeeDetails employeeDetails2 = new EmployeeDetails();
		    employeeDetails2.setFirstName("John");
		    employeeDetails2.setLastName("Travolta");
		    employeeDetails2.setDepartment(ddepartment1);
		    
		    EmployeeDetails employeeDetails3 = new EmployeeDetails();
		    employeeDetails3.setFirstName("Kabat");
		    employeeDetails3.setLastName("Peti");
		    employeeDetails3.setDepartment(ddepartment2);
		    
		    EmployeeDetails employeeDetails4 = new EmployeeDetails();
		    employeeDetails4.setFirstName("Nagy");
		    employeeDetails4.setLastName("Adam");
		    employeeDetails4.setDepartment(ddepartment2);
		    
		    employees.add(employeeDetails1);
		    employees.add(employeeDetails2);
		    employees.add(employeeDetails3);
		    employees.add(employeeDetails4);
		    
		 deparments = new ArrayList<>();
		 Department department1 = new Department("it");
		 Department department2 = new Department("finance");
		 
		 List<Employee> e1 = new ArrayList<Employee>();
		 List<Employee> e2 = new ArrayList<Employee>();
		 
		    Employee employee1 = new Employee();
		    employee1.setFirstName("John");
		    employee1.setLastName("Krugger");
		    
		    Employee employee2 = new Employee();
		    employee2.setFirstName("John");
		    employee2.setLastName("Travolta");
		    
		    e1.add(employee1);
		    e1.add(employee2);
		    
		    Employee employee3 = new Employee();
		    employee3.setFirstName("Kabat");
		    employee3.setLastName("Peti");
		    
		    Employee employee4 = new Employee();
		    employee4.setFirstName("Nagy");
		    employee4.setLastName("Adam");
		    
		    e2.add(employee3);
		    e2.add(employee4);
		    
			Collections.sort(e1, new EmployeeFirstNameComparator());
			Collections.sort(e2, new EmployeeFirstNameComparator());
		    
		    department1.setEmployees(e1);
		    department2.setEmployees(e2);
		    
		    deparments.add(department1);
		    deparments.add(department2);
		    
	when(employeeRepository.getDepartments()).thenReturn(deparments);
	
	assertEquals(deparments, manageEmployeeService.getDepartmentsWithEmployees());

	}
	
	@Test
	void employeeDetailsToEmployee() {
		
	    String ddepartment1[] = {"it"};
		
	    EmployeeDetails employeeDetails1 = new EmployeeDetails();
	    employeeDetails1.setFirstName("John");
	    employeeDetails1.setLastName("Travolta");
	    employeeDetails1.setDepartment(ddepartment1);
	
		 
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Travolta");
		
	    assertEquals(employee1, manageEmployeeService.employeeDetailsToEmployee(employeeDetails1));
	}
	
	@Test
	void hashSetToList() {	
		
		Set<Employee> set = new HashSet<Employee>();
		List<Employee> e1 = new ArrayList<Employee>();
		
	    Employee employee1 = new Employee();
	    employee1.setFirstName("John");
	    employee1.setLastName("Krugger");
	    
	    Employee employee2 = new Employee();
	    employee2.setFirstName("John");
	    employee2.setLastName("Travolta");
	    
	    Employee employee3 = new Employee();
	    employee3.setFirstName("John");
	    employee3.setLastName("Krugger");
	    
	    set.add(employee1);
	    set.add(employee2);
	    set.add(employee3);
	    
	    e1.add(employee1);
	    e1.add(employee2);
	    System.out.println(employee1.equals(employee3));
		Collections.sort(e1, new EmployeeFirstNameComparator());
		assertEquals(e1, manageEmployeeService.hashSetToList(set));
	}
}
