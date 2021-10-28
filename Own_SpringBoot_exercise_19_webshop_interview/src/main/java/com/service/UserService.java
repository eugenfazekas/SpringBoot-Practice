package com.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;
import com.util.UserAgeComparator;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String registerUser(User user) {
		user.setUserid(UUID.randomUUID().toString());
		return userRepository.registerUser(user);
	}
	
	public List<User> findFemaleUsersByBirthDateFrom(String gender, int age) {
		return userRepository.findFemaleUsersByBirthDateFrom(gender, age);
	}
	
	public User findUserById(String id) {
		
		User user = new User();
		
		try {
			user = userRepository.findUserById(id);
		} catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
	
	public String updateUsesOrdersCount (String userId) {
		
		int orders = findUserById(userId).getOrderscount() + 1;
		return userRepository.updateUserOrders(orders, userId);
	}
	
	public String countMalesAndFemails() {
		return userRepository.countMalesAndFemails();
	}
		
	public String getEmailHost(String email) {
		
		Pattern pattern = Pattern.compile("(?<=@)[^.]+(?=\\.)");
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.find())
		{
		    return(matcher.group(0));
		}
		
		return "it is not a valid email address!";
	}
	
	public List<User> findUsersWhoHasBuyedNothing() {
		return userRepository.findUsersWhoHasBuyedNothing();
	}
	
	public List<User> sortByAge() {
		
		List<User> users = userRepository.findAllUsers();
		
		Collections.sort(users, new UserAgeComparator());
		
		return users;
	}

}
