/*
 * 
 * THIS CLASS IS FOR SHEDUCLING AN AUCTION
 * 
 * **/


package com.codefury.model;

import java.time.LocalDate;

public class Sell{
	private long minBid;
	private LocalDate startDate, endDate;
	private Product product;
	
	
	public Sell(long minBid, LocalDate startDate, LocalDate endDate, Product product) {
		this.minBid = minBid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.product = product;
	}
	
	
	
	
}
