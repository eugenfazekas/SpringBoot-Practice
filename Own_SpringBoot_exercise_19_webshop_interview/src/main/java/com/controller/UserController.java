package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody User user) {
		userService.registerUser(user);
	    return user.getEmail();
	}
	
	@RequestMapping(value = "/userByGenderByBirth/{gender}/{birth}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findFemaleUsersByBirthDateFrom(@PathVariable("gender") String gender, @PathVariable("birth") int birth) {
		return userService.findFemaleUsersByBirthDateFrom(gender, birth);
	}
	
	@RequestMapping(value = "/gethost/{mail}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@PathVariable("mail") String mail) {
		return userService.getEmailHost(mail);
	}
	
	@RequestMapping(value = "/findUsersWhoHasBuyedNothing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUsersWhoHasBuyedNothing() {
		return userService.findUsersWhoHasBuyedNothing();
	}
	
	@RequestMapping(value = "/countMalesAndFemails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String countMalesAndFemails() {
		return userService.countMalesAndFemails();
	}
	
	@RequestMapping(value = "/sortByAge", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> sortByAge() {
		return userService.sortByAge();
	}
	
}
