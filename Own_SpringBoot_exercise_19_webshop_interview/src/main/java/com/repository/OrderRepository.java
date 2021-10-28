package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Order;

@Repository
public class OrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final RowMapper<Order> mapper = new RowMapper<Order>() {

		public Order mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Order n = new Order();
			
			n.setOrderid(rs.getString("orderId"));
			n.setUserid(rs.getString("userId"));
			n.setUserName(rs.getString("userName"));
			n.setArticles(rs.getString("articles"));
			n.setPrice(rs.getInt("price"));
			n.setDate(rs.getString("date"));
					
			return n;
		}
	};
	
	
	public String createOrder(Order order) {
		
		final String sql = "INSERT INTO ORDERS (orderid,userid,userName,articles,price,date) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP)";
		jdbcTemplate.update(sql,order.getOrderid(),order.getUserid(),order.getUserName(),order.getArticles(),order.getPrice());
		
		return "Order created";
	}
	
	
	public List<Order> findOrders() {
		
		final String sql = "SELECT * from ORDERS where date >= '2021-01-01' ORDER BY price DESC , userName ";
		
		return jdbcTemplate.query(sql,mapper);
	}
}
