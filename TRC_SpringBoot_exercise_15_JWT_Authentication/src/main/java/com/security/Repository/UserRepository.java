package com.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
  User findByUsername(String username);
  
}
