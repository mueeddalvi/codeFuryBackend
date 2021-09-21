package com.codefury.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codefury.model.Product;
import com.codefury.model.User;

//Imports from model package

public class DAO implements DAOInterface {

	// Global Statements
	private PreparedStatement register, login, addProduct, displaySeller;
	private Connection con;

	// Define constructor and initialize statements
	public DAO() {
		try {
			// Load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			// Create connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineauction", "root", "ssk_230399");
			// Initialize Statements
			register = con.prepareStatement("insert into users(name, dateofbirth, email, phonenumber, "
					+ "username, password, address, typeofuser,walletamount) values(?,?,?,?,?,?,?,?,?);");
			login = con.prepareStatement("select * from users where username=? and password=?");
			addProduct = con.prepareStatement("insert into product(productname, category, description, "
					+ "actualprice, quantity, image, sellerid) values(?,?,?,?,?,?,?)");
			displaySeller = con.prepareStatement("select * from users where userid=?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Register User
	// Remaining: Throw user already exists exception
	public int registerUser(User object) {
		int result = 0;
		try {
			// Set all parameters
			register.setString(1, object.getName());
			// Assumption: Date comes in the format date and not string
			register.setDate(2, java.sql.Date.valueOf(object.getDob()));
			/*
			 * str = object.getDateOfBirth(); Date date=Date.valueOf(str);
			 */
			register.setString(3, object.getEmail());
			register.setLong(4, object.getPhone());
			register.setString(5, object.getEmail());
			register.setString(6, object.getPassword());
			register.setString(7, object.getAddress());
			register.setString(8, object.getTypeOfUser());
			register.setDouble(9, object.getWallet());
			result = register.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	// Login User
	// Remaining: throw user not found exception
	public boolean loginUser(User object) {
		boolean result = false;
		try {
			login.setString(1, object.getUsername());
			login.setString(2, object.getPassword());
			// Execute query
			ResultSet res = login.executeQuery();
			if (res.next())
				result = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	// Add product
	public int addProduct(Product object) {
		int result = 0;
		try {
			addProduct.setString(1, object.getName());
			addProduct.setString(2, object.getCategory());
			addProduct.setString(3, object.getDescription());
			addProduct.setDouble(4, object.getActualPrice());
			addProduct.setInt(5, object.getQuantity());
			addProduct.setString(6, "");
			// SellerID from session
			addProduct.setLong(7, object.getSellerId());
			// Execute Query
			result = addProduct.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public User displaySellerInfo(int id) {
		User user=null;
		try {
			displaySeller.setInt(1, id);
			ResultSet rs = displaySeller.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("name"), rs.getString("email"), rs.getLong("phone"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}
	
	public Product displayProdInfoForSeller() {
		Product prod=null;
		//Seller page Product Information
		
		return prod;
		
	}
}