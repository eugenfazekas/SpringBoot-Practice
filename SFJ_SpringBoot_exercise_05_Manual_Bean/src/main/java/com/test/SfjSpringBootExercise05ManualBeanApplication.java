package com.test;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SfjSpringBootExercise05ManualBeanApplication {

	@Bean
	public Person giveMeAPerson() {
		return new Person("Gyula",20);
	}
	
	public static void main(String[] args) {
	ApplicationContext ct =	SpringApplication.run(SfjSpringBootExercise05ManualBeanApplication.class, args);
	
	String[] beanArray =  ct.getBeanDefinitionNames();
	Arrays.sort(beanArray);
	
	for(String name : beanArray)
		System.out.println(name);
	}

}
