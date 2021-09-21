package com.codefury.dao;

import com.codefury.model.Product;
import com.codefury.model.User;

public interface DAOInterface {
	
	public int registerUser(User object);
	public int addProduct(Product object);
	public User displaySellerInfo(int id);
	public Product displayProdInfoForSeller();
}
