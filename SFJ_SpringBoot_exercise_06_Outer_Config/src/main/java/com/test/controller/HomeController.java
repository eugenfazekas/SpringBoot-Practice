package com.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {

	@Value("${HomeController.msg}")
	private String message;



		@RequestMapping("/")
		public String index() {
		return message;
	}
	
}
