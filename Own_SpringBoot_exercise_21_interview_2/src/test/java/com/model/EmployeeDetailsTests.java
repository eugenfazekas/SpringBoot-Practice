package com.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeDetailsTests {


	public EmployeeDetails getEmployeeDetails() {
		String arr[] = {"it","finance"} ;
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setFirstName("John");
		employeeDetails.setLastName("Markovics");
		employeeDetails.setDepartment(arr);
		return employeeDetails;
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails getter-setter functions")
	void getterSetterTest() {
		String arr[] = {"it","finance"} ;
		EmployeeDetails EmployeeDetails = new EmployeeDetails();
		EmployeeDetails.setEmployeeFirstName("John");
		EmployeeDetails.setEmployeeLastName("Markovics");
		EmployeeDetails.setDepartment(arr);
		
		assertAll(		
	    		 () -> assertEquals("John", EmployeeDetails.getEmployeeFirstName()),
	    		 () -> assertEquals("Markovics",EmployeeDetails.getEmployeeLastName()),
	    		 () -> assertEquals(arr,EmployeeDetails.getDepartment())
	    		 );		
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails equals function with same object")
	void equalsTest1() {

		EmployeeDetails EmployeeDetails = new EmployeeDetails();
		EmployeeDetails.setFirstName("John");
		EmployeeDetails.setLastName("Markovics");
		assertEquals(true,EmployeeDetails.equals(EmployeeDetails));
	}

	@Test
	@DisplayName("Testing EmployeeDetails equals function with equal object")
	void equalsTest2() {

		EmployeeDetails EmployeeDetails2 = new EmployeeDetails();
		EmployeeDetails2.setFirstName("John");
		EmployeeDetails2.setLastName("Markovics");
		assertEquals(true,getEmployeeDetails().equals(EmployeeDetails2));
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails equals function with modified object")
	void equalsTest3() {

		EmployeeDetails EmployeeDetails2 = new EmployeeDetails();
		EmployeeDetails2.setFirstName("John2");
		EmployeeDetails2.setLastName("Markovics1");
		assertEquals(false,getEmployeeDetails().equals(EmployeeDetails2));
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails equals function with null")
	void equalsTest4() {

		assertEquals(false,getEmployeeDetails().equals(null));
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails equals function with other object")
	void equalsTest5() {

		assertEquals(false,getEmployeeDetails().equals(new Employee()));
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails hashCode function with equal objects")
	void hashCodeTest1() {
		
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John");
		employee1.setLastName("Markovics");
		
		EmployeeDetails employee2 = new EmployeeDetails();
		employee2.setFirstName("John");
		employee2.setLastName("Markovics");


		assertEquals(true,employee1.hashCode() == employee2.hashCode());
	}
	
	@Test
	@DisplayName("Testing EmployeeDetails hashCode function with non equal objects")
	void hashCodeTest2() {
		
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setFirstName("John1");
		employee1.setLastName("Markovics");
		
		EmployeeDetails employee2 = new EmployeeDetails();
		employee2.setFirstName("John");
		employee2.setLastName("Markovics");

		assertEquals(true,employee1.hashCode() != employee2.hashCode());
	}
		
	@Test
	@DisplayName("Testing EmployeeDetails User toString function")
	void toStringTest() {
		
		assertEquals("Employee [firstName=" + "John"+ ", lastName=" + "Markovics" + ", department="
				+ Arrays.toString(getEmployeeDetails().getDepartment()) + "]",getEmployeeDetails().toString());
	}
}
