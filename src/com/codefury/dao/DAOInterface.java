package com.codefury.dao;

import com.codefury.exceptions.UserAlreadyExists;
import com.codefury.model.User;

public interface DAOInterface {
	
	public int registerUser(User object) throws UserAlreadyExists;
}
