package com.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.Repository.UserRepository;
import com.security.model.User;

@Service
public class DbInit implements CommandLineRunner {

	private UserRepository userRepository;
	
	@Autowired
	public DbInit(UserRepository userRepository ) {
		this.userRepository = userRepository;
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		User eugen = new User("Eugen",new BCryptPasswordEncoder().encode("pass"),"USER", "");
		User admin = new User("Admin",new BCryptPasswordEncoder().encode("pass"),"ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
		User manager = new User("Manager",new BCryptPasswordEncoder().encode("pass"),"MANAGER", "ACCESS_TEST1");
		
		List<User> users = Arrays.asList(eugen,admin,manager);
		
		userRepository.saveAll(users);
	}
}
