package com.codefury.service;

import com.codefury.dao.DAOInterface;
import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
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

	@Override
	public void addProduct(Product object) {
		// TODO Auto-generated method stub
		
	}
}