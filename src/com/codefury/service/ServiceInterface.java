package com.codefury.service;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.Auction;
import com.codefury.model.Product;
import com.codefury.model.User;

public interface ServiceInterface {

	int register(User object) throws UserAlreadyExistsException;

	User login(User object) throws IncorrectCredentialsException;

	int addProduct(Product object);

	User displaySeller(User object);
	
	boolean getProducts(int id);

	int scheduleAuction(Auction auctionobject, User object);

}

