package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.Order;
import com.model.User;
import com.repository.UserRepository;

@Component
public class MyCommandLineRunnner implements CommandLineRunner{

	private UserRepository userRepository;
	private OrderService orderService;



	public MyCommandLineRunnner(UserRepository userRepository, OrderService orderService) {
		this.userRepository = userRepository;
		this.orderService = orderService;
	}

	@Override
	public void run(String... args) throws Exception {

		insertDummyUsers();
		System.out.println(userRepository.countMalesAndFemails());
		insertDummyOrders();
	}
	
	public List<User> createDummyUsers() {
		
		List<String> orders = new ArrayList<String>();
		orders.add(" ");
		
		User user1 = new User("2e9447b2-6ad3-4f07-88fd-bb99345b9846","Joco","joco@freemail.hu", 1990,"male", 0);
		User user2 = new User("d07955b1-cb08-41e7-b573-a555b44c8025","Jucika","jucika@gmail.com", 1985,"female", 0);
		User user3 = new User("e5cebb5a-70d3-49f0-b0d3-5a261a80889c","KissPista","kissPista@freemail.hu", 1997,"male", 0);
		User user4 = new User("e8447117-2bd2-487f-8718-098bc1d7068c","Orsika","orsika@yahoo.co", 1996,"female", 0);
		User user5 = new User("dc35da3a-380b-40b9-8b4a-9026f69121bc","Moricka","moricka@freemail.ro", 2006,"male", 0);
		User user6 = new User("493f0f44-faf8-4a27-ae53-f82b72b14b8c","Loch-neszi szorny","lochnesziszorny@origo.hu", 1980,"male", 0);
		User user7 = new User("5784ee44-16db-4d6a-92f5-5b83ad816188","Mancika","mancika@kgb.ru", 1988,"female", 0);
		
		return Arrays.asList(user1,user2,user3,user4,user5,user6,user7);				
	}
	
	void insertDummyUsers() {
		
		for( User user : createDummyUsers() ) {			
			userRepository.registerUser(user);
			System.out.println(user);
		}
	}
	
	public List<Order> createDummyOrders() {
		
		Order order1 = new Order("orderId1","2e9447b2-6ad3-4f07-88fd-bb99345b9846","Joco", "legypapir",500);
		Order order2 = new Order("orderId2","e5cebb5a-70d3-49f0-b0d3-5a261a80889c","KissPista", "TermoNuklearis Hosugarzo",1000000);
		Order order3 = new Order("orderId3","493f0f44-faf8-4a27-ae53-f82b72b14b8c","Loch-neszi szorny", "Ir fotos csoport",80000);
		Order order4 = new Order("orderId4","dc35da3a-380b-40b9-8b4a-9026f69121bc","Moricka", "homokozo-lapat",500);
		
		return Arrays.asList(order1,order2,order3,order4);
	}
	
	void insertDummyOrders() {
		
		for( Order order : createDummyOrders())  {			
			orderService.createOrder(order);
			System.out.println(order);
		}
	}
}
