package com.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTests {
	
	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Markovics");
		return employee;
	}
	
	@Test
	@DisplayName("Testing Employee getter-setter functions")
	void getterSetterTest() {
		
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Markovics");
		
		Employee employee2 = new Employee("John1","Marcovics1");

		
		assertAll(		
	    		 () -> assertEquals("John", employee.getFirstName()),
	    		 () -> assertEquals("Markovics",employee.getLastName()),
	    		 () -> assertEquals("John1",employee2.getFirstName()),
	    		 () -> assertEquals("Marcovics1",employee2.getLastName())
	    		 );		
	}
	
	@Test
	@DisplayName("Testing Employee equals function with same object")
	void equalsTest1() {

		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Markovics");
		assertEquals(true,employee.equals(employee));
	}

	@Test
	@DisplayName("Testing Employee equals function with equal object")
	void equalsTest2() {

		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Markovics");
		assertEquals(true,getEmployee().equals(employee2));
	}
	
	@Test
	@DisplayName("Testing Employee equals function with modified object")
	void equalsTest3() {

		Employee employee2 = new Employee();
		employee2.setFirstName("John2");
		employee2.setLastName("Markovics1");
		assertEquals(false,getEmployee().equals(employee2));
	}
	
	@Test
	@DisplayName("Testing Employee equals function with null")
	void equalsTest4() {

		assertEquals(false,getEmployee().equals(null));
	}
	
	@Test
	@DisplayName("Testing Employee equals function with other object")
	void equalsTest5() {


		assertEquals(false,getEmployee().equals(new EmployeeDetails()));
	}
	
	@Test
	@DisplayName("Testing Employee hashCode function with equal objects")
	void hashCodeTest1() {
		
		Employee employee1 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Markovics");


		assertEquals(true,employee1.hashCode() == employee2.hashCode());
	}
	
	@Test
	@DisplayName("Testing Employee hashCode function with non equal objects")
	void hashCodeTest2() {
		
		Employee employee1 = new Employee();
		employee1.setFirstName("John1");
		employee1.setLastName("Markovics");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Markovics");


		assertEquals(true,employee1.hashCode() != employee2.hashCode());
	}
		
	@Test
	@DisplayName("Testing Employee User toString function")
	void toStringTest() {
		
		assertEquals("Employee [firstName=" + "John" + ", lastName=" + "Markovics" + "]",getEmployee().toString());
	}

}
