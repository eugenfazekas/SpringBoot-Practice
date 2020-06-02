 package com.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.Repository.UserRepository;
import com.security.model.User;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
		
	private UserRepository userRepository;

	public PublicRestApiController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("test1")
	public String test1() {
		return "API Test";
	}
	
	@GetMapping("management/reports")
	public String reports() {
		return "Some report data";
	}
	
	@GetMapping("admin/users")
	public List<User> users() {
		
		return userRepository.findAll();
	}
	
}
