package com.test.service;

import org.springframework.stereotype.Service;

@Service("spying")
public class SpyService {

	public String spyService() {
		return "I'm a spy";
	}
	
}
