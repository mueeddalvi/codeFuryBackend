package com.codefury.model;

public class Category {
	
	private long uId;
	private String name, description;
	
	
	public Category(long uId, String name, String description) {
		this.uId = uId;
		this.name = name;
		this.description = description;
	}


	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	
}
