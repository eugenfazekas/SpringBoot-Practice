package com.test;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.test","com.spy"})
@SpringBootApplication
public class SfjSpringBootExercize04ServiceLayerApplication {

	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(SfjSpringBootExercize04ServiceLayerApplication.class, args);
		
		String[] beanArray =  ct.getBeanDefinitionNames();
		Arrays.sort(beanArray);
		
		for(String name : beanArray)
			System.out.println(name);
	}

}
