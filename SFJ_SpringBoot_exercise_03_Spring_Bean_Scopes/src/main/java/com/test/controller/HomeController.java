package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.SpyGirl;

@RestController
public class HomeController {

	
	private SpyGirl spicy;
	
	
	@Autowired
		public void setSpicy(SpyGirl spicy) {
		this.spicy = spicy;
	}



		@RequestMapping("/")
		public String index() {
		return spicy.iSaySomething();
	}
	
}
