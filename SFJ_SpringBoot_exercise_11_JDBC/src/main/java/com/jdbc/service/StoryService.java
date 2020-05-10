package com.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.domain.Story;
import com.jdbc.repository.BloggerRepository;
import com.jdbc.repository.StoryRepository;

@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
//	public Story getStory(){
//		return storyRepo.findFirstByOrderByPostedDesc();
//	}
//
	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}
//
//	public List<Story> getStoriesByBloggerName(String name) {
//		
//		return storyRepo.findByBloggerNameIgnoreCaseOrderByPostedDesc(name);
//	}
	
	

}
