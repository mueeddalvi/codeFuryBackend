package com.codefury.service;

import com.codefury.exceptions.UserAlreadyExists;
import com.codefury.model.User;

public interface UserService {
	int store(User user)throws Exception, UserAlreadyExists;
}
