package com.codefury.service;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.Product;
import com.codefury.model.User;

public interface ServiceInterface {

	int register(User object) throws UserAlreadyExistsException;

	User login(User object) throws IncorrectCredentialsException;

	void addProduct(Product object);

}
