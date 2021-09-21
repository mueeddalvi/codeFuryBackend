package com.codefury.model;

public class Product extends Category{
	private long pId, actualPrice, sellerId;
	private String name, category, description;
	private int quantity;
	
	public Product(long actualPrice, long sellerId, String name, String category, String description, int quantity) {
		super(category,description);
		this.actualPrice = actualPrice;
		this.sellerId = sellerId;
		this.name = name;
		this.quantity=quantity;
	}


	public Product(long pId, long actualPrice, long sellerId, String name, String category, String description, int quantity) {
		super(category, description);
		this.pId = pId;
		this.actualPrice = actualPrice;
		this.sellerId = sellerId;
		this.name = name;
		this.quantity=quantity;
	}
	
	
	
	
}
