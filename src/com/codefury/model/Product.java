package com.codefury.model;

public class Product extends Category{
	private long pId, sellerId;
	private String name, category, description;
	private int quantity;
	private double actualPrice;
	
	public Product(double actualPrice, long sellerId, String name, String category, String description, int quantity) {
		super(category,description);
		this.actualPrice = actualPrice;
		this.sellerId = sellerId;
		this.name = name;
		this.quantity=quantity;
	}


	public Product(long pId, double actualPrice, long sellerId, String name, String category, String description, int quantity) {
		super(category, description);
		this.pId = pId;
		this.actualPrice = actualPrice;
		this.sellerId = sellerId;
		this.name = name;
		this.quantity=quantity;
	}


	public long getpId() {
		return pId;
	}


	public double getActualPrice() {
		return actualPrice;
	}


	public long getSellerId() {
		return sellerId;
	}


	public String getName() {
		return name;
	}


	public String getCategory() {
		return category;
	}


	public String getDescription() {
		return description;
	}


	public int getQuantity() {
		return quantity;
	}
	
	


	}
	
