package com.codefury.dao;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.User;

public interface DAOInterface {
	
	public int registerUser(User object) throws UserAlreadyExistsException;

	public User loginUser(User object) throws IncorrectCredentialsException;

	public void retrieveProductsBySeller(int id);
}
