package com.wusi.mybatis.pojo;

public class User {
	private int id;
	private String userName;
	private String sex;
	private String address;
	
	
	public User() {
		super();
	}
	public User(String userName, String sex, String address) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
