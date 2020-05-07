package com.test.entity;

import org.springframework.stereotype.Component;

@Component
public class Person2 {

	private String name;	
	private int age;
	private String message;

	public Person2() {
		
	}

	public Person2(String message) {
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Person2 [message2=" + message  ;
	}

}
