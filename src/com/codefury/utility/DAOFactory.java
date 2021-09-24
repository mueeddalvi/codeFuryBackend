package com.codefury.utility;

import com.codefury.dao.DAO;
import com.codefury.dao.DAOInterface;

public class DAOFactory {

	public static DAOInterface createDAOObject() {
		return new DAO();
	}
}