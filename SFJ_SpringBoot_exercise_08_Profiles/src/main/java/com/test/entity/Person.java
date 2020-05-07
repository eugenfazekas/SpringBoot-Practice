package com.test.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;	
	private int age;
	
	@Value("${msg}")
	private String message;
	
	@Value("${spring.profiles.active}")
	private String selectedProfile;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSelectedProfile() {
		return selectedProfile;
	}

	public void setSelectedProfile(String selectedProfile) {
		this.selectedProfile = selectedProfile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Person [message=" + message + ", selectedProfile=" + selectedProfile + "]";
	}

}
