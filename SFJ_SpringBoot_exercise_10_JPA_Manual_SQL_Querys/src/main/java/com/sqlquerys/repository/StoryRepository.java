package com.sqlquerys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sqlquerys.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

	//SELECT * FROM STORY
	List<Story> findAll();
	
	//SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
	Story findFirstByOrderByPostedDesc();
	
	
	//@Query(value = "select * from story where title = ?1 limit 1",nativeQuery = true)
	//@Query(value = "select * from story where title = :title limit 1",nativeQuery = true)
	@Query(value = "select s from story where s.title = ?1 limit 1")
	Story findByTitle(@Param("title") String title);
	
	 List <Story> findByBloggerNameIgnoreCaseOrderByPostedDesc(String name);
	
}
