package com.test.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "person")
@Component
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String phoneNumber;
	
	public Person() {
	}

	public Person(String firstName, String lastName, int age, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
