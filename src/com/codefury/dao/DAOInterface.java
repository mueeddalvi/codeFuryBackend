package com.codefury.dao;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.Auction;
import com.codefury.model.Product;
import com.codefury.model.User;

public interface DAOInterface {
	
	public int registerUser(User object) throws UserAlreadyExistsException;

	public User loginUser(User object) throws IncorrectCredentialsException;

	public int addProduct(Product object);

	public User displaySeller(User object);
	
	public boolean displayProdInfoForSeller(int id);

	public int scheduleAuction(Auction auctionobject, User object);
}
