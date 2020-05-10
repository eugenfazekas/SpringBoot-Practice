package com.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdbc.service.StoryService;

@Controller
public class HomeController {
	
	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String stories(Model model) {
		model.addAttribute("stories", storyService.getStories());
		
				
		return "stories";
	}
	
//	@RequestMapping("/story")
//	public String story(Model model) {
//		model.addAttribute("pageTitle", "Minden napra egy SFJ sztori!");
//		model.addAttribute("story", storyService.getStory());
//		return "story";
//	}
//
	@RequestMapping("/title/{title}")
	public String searchForUser(@PathVariable(value = "title") String title, Model model) throws Exception {
		if (title == null)
			throw new Exception("Nincs ilyen címmel sztorink!");
		model.addAttribute("story", storyService.getSpecificStory(title));
		return "story";
	}

	




}
