package com.codefury.model;

import java.time.LocalDate;

public class User {
	private int uid;
	private String name,email,username,password,address,typeOfUser;
	private double wallet;
	private long phone;
	private LocalDate dob;
	
	/*
	 * CONSTRUCTOR WHEN TAKING INPUT FROM WEB-APP
	 * */
	public User(String name, String email, String username, String password, String address, String typeOfUser,
			double wallet, long phone, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.typeOfUser = typeOfUser;
		this.wallet = wallet;
		this.phone = phone;
		this.dob = dob;
	}

	/*
	 * CONSTRUCTOR WHEN DISPLAYING ON WEB-APP
	 * */
	
	public User(int uid, String name, String email, String username, String password, String address, String typeOfUser,
			double wallet, long phone, LocalDate dob) {
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.typeOfUser = typeOfUser;
		this.wallet = wallet;
		this.phone = phone;
		this.dob = dob;
	}

	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public double getWallet() {
		return wallet;
	}

	public long getPhone() {
		return phone;
	}

	public LocalDate getDob() {
		return dob;
	}
	
	
	
	
	
	
}
