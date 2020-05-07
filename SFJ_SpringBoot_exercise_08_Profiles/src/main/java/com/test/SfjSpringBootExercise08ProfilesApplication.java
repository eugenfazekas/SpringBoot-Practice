package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.test.entity.Person2;

@SpringBootApplication
public class SfjSpringBootExercise08ProfilesApplication {

	@Bean(name="Gyula")
	@Profile("dev")
	public Person2 giveMeADevPerson2() {
		return new Person2("deviance");
	}
	
	@Bean(name="Gyula")
	@Profile("prod")
	public Person2 giveMeAProdPerson2() {
		return new Person2("production");
	}
	
	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(SfjSpringBootExercise08ProfilesApplication.class, args);
		System.out.println(ct.getBean("person"));
		System.out.println(ct.getBean("Gyula"));
	}

}
