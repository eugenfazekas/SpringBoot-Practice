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

import com.model.Department;
import com.model.Employee;
import com.model.EmployeeDetails;
import com.repository.EmployeeRepository;
import com.util.EmployeeFirstNameComparator;

@SpringBootTest

public class DepartmentServiceTests {
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentService departmentService;
	private List<EmployeeDetails> employees;
	private EmployeeDetails employeeDetails;
	private List<Department> deparments;

	@Test
	@DisplayName("Testing DepartmentService initDepartments function")
	void initDepartments1() {
		
	    employees = new ArrayList<EmployeeDetails>();
	    deparments = new ArrayList<Department>();
	    employeeDetails = new EmployeeDetails();
	    
	    String department[] = {"it"};
	    
	    employeeDetails.setFirstName("John");
	    employeeDetails.setLastName("Krugger");
	    employeeDetails.setDepartments(department);
	    
	    employees.add(employeeDetails);
	    
		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(1, departmentService.initDepartments());
	}
	
	@Test
	@DisplayName("Testing DepartmentService initDepartments function")
	void initDepartments2() {
		
	    employees = new ArrayList<EmployeeDetails>();

		when(employeeRepository.getEmployeeDetails()).thenReturn(employees);		
		
		assertEquals(0, departmentService.initDepartments());
	}
	
	@Test
	@DisplayName("Testing DepartmentService addDepartment function")
	void addDepartment1() {
		
	    deparments = new ArrayList<Department>();
		
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		when(employeeRepository.addDepartment(new Department("it"))).thenReturn("addDepartment");
		assertEquals("addDepartment", departmentService.addDepartment("it"));
	}
	
	@Test
	@DisplayName("Testing DepartmentService addDepartment function")
	void addDepartment2() {

	    deparments = new ArrayList<Department>();
	    deparments.add(new Department("it"));
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		when(employeeRepository.addDepartment(new Department("it"))).thenReturn("addDepartment");
		
		assertEquals(null, departmentService.addDepartment("it"));
	}
	
	@Test
	@DisplayName("Testing DepartmentService departmentExist function")
	void departmentExist1() {		

	    deparments = new ArrayList<Department>();
	    	
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(0, departmentService.departmentExist("it"));
		
	}
	
	@Test
	@DisplayName("Testing DepartmentService departmentExist function")
	void departmentExist2() {		

	    deparments = new ArrayList<Department>();
	    deparments.add(new Department("it"));
	    	
		when(employeeRepository.getDepartments()).thenReturn(deparments);
		
		assertEquals(1, departmentService.departmentExist("it"));
	}
	
	@Test
	@DisplayName("Testing DepartmentService getDepartmentsWithEmployees function")
	void getDepartmentsWithEmployees() {
		 employees = new ArrayList<EmployeeDetails>();
		 
		    String ddepartment1[] = {"it"};
		    String ddepartment2[] = {"finance"};
		    		 
		    EmployeeDetails employeeDetails1 = new EmployeeDetails();
		    employeeDetails1.setFirstName("John");
		    employeeDetails1.setLastName("Krugger");
		    employeeDetails1.setDepartments(ddepartment1);
		    
		    EmployeeDetails employeeDetails2 = new EmployeeDetails();
		    employeeDetails2.setFirstName("John");
		    employeeDetails2.setLastName("Travolta");
		    employeeDetails2.setDepartments(ddepartment1);
		    
		    EmployeeDetails employeeDetails3 = new EmployeeDetails();
		    employeeDetails3.setFirstName("Kabat");
		    employeeDetails3.setLastName("Peti");
		    employeeDetails3.setDepartments(ddepartment2);
		    
		    EmployeeDetails employeeDetails4 = new EmployeeDetails();
		    employeeDetails4.setFirstName("Nagy");
		    employeeDetails4.setLastName("Adam");
		    employeeDetails4.setDepartments(ddepartment2);
		    
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
	
	assertEquals(deparments, departmentService.getDepartmentsWithEmployees());

	}
}
