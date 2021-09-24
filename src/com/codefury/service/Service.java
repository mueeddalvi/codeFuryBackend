package com.codefury.service;

import com.codefury.dao.DAOInterface;
import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.Auction;
import com.codefury.model.Product;
import com.codefury.model.User;
import com.codefury.utility.DAOFactory;

public class Service implements ServiceInterface {

	private DAOInterface dao;
	public Service() {
		 dao = DAOFactory.createDAOObject(); 
	}
	
	public int register(User object) throws UserAlreadyExistsException{
		return dao.registerUser(object);
	}

	public User login(User object) throws IncorrectCredentialsException {
		return dao.loginUser(object);
	}
	
	public int addProduct(Product object) {
		return dao.addProduct(object);
	}

	public User displaySeller(User object) {
		return dao.displaySeller(object);
	}

	public int scheduleAuction(Auction auctionobject, User object) {
		return dao.scheduleAuction(auctionobject, object);
	}
}