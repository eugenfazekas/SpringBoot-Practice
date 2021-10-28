package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	final RowMapper<User> mapper = new RowMapper<User>() {

		public User mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			User n = new User();
			
			n.setUserid(rs.getString("userid"));
			n.setUsername(rs.getString("username"));
			n.setEmail(rs.getString("email"));
			n.setAge(rs.getInt("age"));
			n.setGender(rs.getString("gender"));
			n.setOrderscount(rs.getInt("orderscount"));	
			
			return n;
		}
	};
	
	public String registerUser(User user) {
		
		final String sql = "INSERT INTO USERS (userId,userName,email,age,gender,orderscount) VALUES (?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,user.getUserid(),user.getUsername(),user.getEmail(),user.getAge(),user.getGender(),user.getOrderscount()
					);
		return "User Registered";
	}
	
	
	public List<User> findFemaleUsersByBirthDateFrom(String gender,int age) {

		final String sql = "SELECT * FROM USERS WHERE gender = ? AND age >= ? ORDER BY AGE ASC";
		
		return jdbcTemplate.query(sql,mapper,gender,age);

	}
	
	public User findUserById(String userId) {
	
		final String sql = "SELECT * from USERS  WHERE userid = ?";
		
		return jdbcTemplate.queryForObject(sql,mapper,userId);

	}
	
		
	public String updateUserOrders(int orders, String userId) {

		final String sql = "UPDATE USERS SET orderscount = ?  where userid = ?";
		
		jdbcTemplate.update(sql, new Object[] {orders,userId});
		
		return "User Orders updated to "+ orders;
	}
	
	
			
	public String countMalesAndFemails() {
		
		final String sql = "SELECT COUNT(*)  FROM USERS WHERE gender = ?";
	
		int females = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {"female"} ); 
		int males = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {"male"} ); 
		
		return "There are " + females + " females and " + males +" males in the DB";
		
	}
	
	public List<User> findUsersWhoHasBuyedNothing() {
		
		final String sql = "SELECT *  FROM USERS WHERE orderscount = 0";
		
		return jdbcTemplate.query(sql,mapper);
	}
	
	public List<User> findAllUsers() {
		
		final String sql = "SELECT *  FROM USERS";
		
		return jdbcTemplate.query(sql,mapper);
	}	
}
