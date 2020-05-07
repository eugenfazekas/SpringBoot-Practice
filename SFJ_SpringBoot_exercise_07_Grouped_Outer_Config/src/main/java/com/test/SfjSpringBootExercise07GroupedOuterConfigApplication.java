package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@EnableConfigurationProperties
@SpringBootApplication
public class SfjSpringBootExercise07GroupedOuterConfigApplication {

	public static void main(String[] args) {
    
	ApplicationContext ct =	SpringApplication.run(SfjSpringBootExercise07GroupedOuterConfigApplication.class, args);
	
	System.out.println(ct.getBean("person"));
	}

}
