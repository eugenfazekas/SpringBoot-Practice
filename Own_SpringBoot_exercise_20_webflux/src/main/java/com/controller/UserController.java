package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

import reactor.core.publisher.Flux;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public Flux<User> getUers() {
		return userService.getUsers();
	}
}
