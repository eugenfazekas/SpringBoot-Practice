package com.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Department;
import com.model.Employee;
import com.model.EmployeeDetails;

@SpringBootTest

public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private List<Employee> employees;
	private List<Department> departments;


	@Test
	@DisplayName("Testing EmployeeRepository registerEmployee function")
	void a1() {
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		EmployeeDetails employee2 = new EmployeeDetails();
		employee2.setFirstName("John");
		employee2.setLastName("Krugger");
		
		assertEquals("EMPLOYEEDETAILS Registered", employeeRepository.registerEmployee(employee1,"it"));
		assertEquals("EMPLOYEEDETAILS Registered", employeeRepository.registerEmployee(employee2,"it"));
	}
	
	@Test
	@DisplayName("Testing EmployeeRepository getEmployees function")
	void a2() {
		
		employees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Krugger");
		
		employees.add(employee1);
		employees.add(employee2);
		
		assertEquals(employees, employeeRepository.getEmployees());
	}
	
	@Test
	@DisplayName("Testing EmployeeRepository getEmployeeDetails function")
	void a3() {
		
		List<String> departments = new ArrayList<String>();
		departments.add("it");
		departments.add("it");
		
		assertEquals(departments, employeeRepository.getDepartments());
	}	
	
	@Test
	@DisplayName("Testing EmployeeRepository getEmployeeDetails function")
	void a4() {
		
		String dep[] = {"it"};
		List<String> departments = new ArrayList<String>();
		departments.add("it");
		
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		assertEquals(1, employeeRepository.employeeDetailsExistCheck(employee1,"it"));
	}
	
	@Test
	@DisplayName("Testing EmployeeRepository getEmployeeByDepartment function")
	void a5() {
		
		employees = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Krugger");
		
		employees.add(employee1);
		employees.add(employee2);
		
		
		assertEquals(employees, employeeRepository.getEmployeesByDepartment("it"));
	}
}
