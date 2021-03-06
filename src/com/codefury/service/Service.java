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
	
	@Override
	public int register(User object) throws UserAlreadyExistsException{
		return dao.registerUser(object);
	}

	@Override
	public User login(User object) throws IncorrectCredentialsException {
		return dao.loginUser(object);
	}
	
	@Override
	public int addProduct(Product object) {
		return dao.addProduct(object);
	}

	@Override
	public User displaySeller(User object) {
		return dao.displaySeller(object);
	}

	@Override
	public int scheduleAuction(Auction auctionobject, User object) {
		return dao.scheduleAuction(auctionobject, object);
	}

	@Override
	public boolean getProducts(int id) {
		return dao.displayProdInfoForSeller(id);
	}
}