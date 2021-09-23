package com.codefury.model;

import java.sql.Date;

public class Auction {

	private String productname;
	private double minimumbid;
	private Date bidstart;
	private Date bidend;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getMinimumbid() {
		return minimumbid;
	}
	public void setMinimumbid(double minimumbid) {
		this.minimumbid = minimumbid;
	}
	public Date getBidstart() {
		return bidstart;
	}
	public void setBidstart(Date bidstart) {
		this.bidstart = bidstart;
	}
	public Date getBidend() {
		return bidend;
	}
	public void setBidend(Date bidend) {
		this.bidend = bidend;
	}
}
