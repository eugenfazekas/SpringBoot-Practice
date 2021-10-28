package com.model;

import java.util.Objects;

public class Order {

	private String orderid;
	private String userid;
	private String userName;
	private String articles;
	private int price;
	private String date;
	
	public Order() {
	}

	public Order(String orderid, String userid, String userName, String articles, int price) {
		this.orderid = orderid;
		this.userid = userid;
		this.userName = userName;
		this.articles = articles;
		this.price = price;
	}


	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderid, other.orderid);
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", userName=" + userName + ", articles=" + articles
				+ ", price=" + price + ", date=" + date + "]";
	}
}
