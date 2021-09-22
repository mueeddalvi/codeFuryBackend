package com.codefury.service;

import com.codefury.dao.DAO;
import com.codefury.dao.DAOInterface;
import com.codefury.exceptions.UserAlreadyExists;
import com.codefury.model.User;

public class UserImpl implements UserService {

	@Override
	public int store(User user) throws Exception, UserAlreadyExists {
		// TODO Auto-generated method stub
		DAOInterface dao=new DAO();
		
		try {
			int result=dao.registerUser(user);
			if(result<0) {
				throw new Exception("Something went wrong!");
			}
			return result;
		}catch(UserAlreadyExists uae) {
			throw new UserAlreadyExists(uae.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return -1;
	}

}
