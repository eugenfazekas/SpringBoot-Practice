package com.sec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	
	@RequestMapping("/")
	public String index() {
		return "MainPage";
	}
	
	
	@RequestMapping("/stories")
	public String stories() {
		return "Stories";
	}
	
	
	@RequestMapping("/delete")
	public String delete() {
		return "Delete";
	}
}
