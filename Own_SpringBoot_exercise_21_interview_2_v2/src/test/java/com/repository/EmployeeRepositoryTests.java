package com.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Department;
import com.model.EmployeeDetails;
import com.service.MyCommandLineRunner;

@SpringBootTest

public class EmployeeRepositoryTests {
	
	@MockBean
	private MyCommandLineRunner myCommandLineRunner;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private List<EmployeeDetails> employees;
	private List<Department> departments;

	@Test

	void a3() {
		
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John1");
		employee1.setLastName("Markovics");
		
		employees = new ArrayList<>();
		employees.add(employee1);
		
		assertEquals(employees, employeeRepository.getEmployeeDetails());
	}
	@Test

	void a4() {
		
		Department department1 = new Department("it");
		departments = new ArrayList<>();
		departments.add(department1);
		
		assertEquals(departments, employeeRepository.getDepartments());
	}	
	@Test

	void a1() {
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John1");
		employee1.setLastName("Markovics");
		assertEquals("addEmployees", employeeRepository.addEmployee(employee1));
	}
	@Test
	void a2() {
		Department department1 = new Department("it");
		assertEquals("addDepartment", employeeRepository.addDepartment(department1));
	}
}