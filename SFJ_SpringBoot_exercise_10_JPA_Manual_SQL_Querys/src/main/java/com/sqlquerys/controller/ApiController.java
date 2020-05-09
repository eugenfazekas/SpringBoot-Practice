package com.sqlquerys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqlquerys.domain.Story;
import com.sqlquerys.service.StoryService;

@RestController
public class ApiController {
	
	private StoryService storyService;
	
	
		@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

		@RequestMapping("/story")
	public Story story() {
		return storyService.getStory();
	}
	
		@RequestMapping("/title/{title}")
	public Story searchForUser(@PathVariable(value = "title") String title ) throws Exception {
		return storyService.getSpecificStory(title);
	}

		@RequestMapping("/name/{name}")
	public List<Story> searchForStoriesByBloggerName(@PathVariable(value = "name") String name ) throws Exception {
		return storyService.getStoriesByBloggerName(name);
	}
}
