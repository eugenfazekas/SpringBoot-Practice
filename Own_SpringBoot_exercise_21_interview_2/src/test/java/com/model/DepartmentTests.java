package com.model;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentTests {
	
	private List<Employee> employees;
	
	@Test
	@DisplayName("Testing Department getter-setter functions")
	void getterSetterTest() {
		
		employees = new ArrayList<>();
		employees.add(new Employee());
		Department department = new Department();
		Department department2 = new Department("it");
		department.setDepartmentName("finance");
		department.setEmployees(employees);
		
		assertAll(		
	    		 () -> assertEquals("finance", department.getDepartmentName()),
	    		 () -> assertEquals(employees,department.getEmployees()),
	    		 () -> assertEquals("it",department2.getDepartmentName())
	    		);		
	}	

	@Test
	@DisplayName("Testing Department equals function with equal object")
	void equalsTest1() {

		Department department1 = new Department("it",employees);
		Department department2 = new Department("it",employees);
		
		assertEquals(true,department1.equals(department2));
	}
	
	@Test
	@DisplayName("Testing Department equals function with modified object")
	void equalsTest2() {

		Department department1 = new Department("it",employees);
		Department department2 = new Department("finance",employees);

		assertEquals(false,department1.equals(department2));
	}
	
	@Test
	@DisplayName("Testing Department equals function with null")
	void equalsTest3() {

		Department department1 = new Department("it",employees);
		assertEquals(false,department1.equals(null));
	}
	
	@Test
	@DisplayName("Testing Department equals function with other object")
	void equalsTest4() {

		Department department1 = new Department("it",employees);
		assertEquals(false,department1.equals(new Employee()));
	}
	
	@Test
	@DisplayName("Testing Department equals function with same object")
	void equalsTest5() {

		Department department1 = new Department("it",employees);
		assertEquals(true,department1.equals(department1));
	}
	
	@Test
	@DisplayName("Testing Department hashCode function with equal objects")
	void hashCodeTest1() {
		
		Department department1 = new Department("it");
		Department department2 = new Department("it");


		assertEquals(true,department1.hashCode() == department2.hashCode());
	}
	
	@Test
	@DisplayName("Testing Department hashCode function with non equal objects")
	void hashCodeTest2() {
		
		Department department1 = new Department("it");
		Department department2 = new Department("it2");


		assertEquals(true, department1.hashCode() != department2.hashCode());
	}
	
	@Test
	@DisplayName("Testing Department toString function")
	void toStringTest() {

		Department department1 = new Department("it",employees);
		
		assertEquals("Department [departmentName=" + "it" + ", employees=" + employees + "]",department1.toString());
	}
}
