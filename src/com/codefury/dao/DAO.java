package com.codefury.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
//Imports from model package
import com.codefury.model.Product;
import com.codefury.model.User;

public class DAO implements DAOInterface {
	
	// Global Statements
	private PreparedStatement register,login,lastloggedin,addProduct,displaySeller,viewProfile, retrieveByProductsId;
	private Connection con;
	
	// Define constructor and initialize statements
	public DAO() {
		try {
			// Load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			// Create connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineauction","root","ssk_230399");
			// Initialize Statements
			register = con.prepareStatement("insert into users(name, dateofbirth, email, phonenumber, "
					+ "username, password, address, typeofuser,walletamount) values(?,?,?,?,?,?,?,?,?);");
			/*
			register = con.prepareStatement("insert into users(name, email, phonenumber, "
					+ "username, password, address, typeofuser,walletamount) values(?,?,?,?,?,?,?,?);");
			*/
			login = con.prepareStatement("select typeofuser from users where username=? and password=?");
			viewProfile = con.prepareStatement("select * from users where username=?");
			lastloggedin = con.prepareStatement("update users set lastloggedin=current_timestamp"
					+ " where username=?");
			addProduct = con.prepareStatement("insert into product(productname, category, description, "
					+ "actualprice, quantity, image, sellerid) values(?,?,?,?,?,?,?)");
			displaySeller = con.prepareStatement("select name,email,phonenumber,lastloggedin from users where "
					+ "sellerid=?");
			
			retrieveByProductsId=con.prepareStatement("select product.productname from product inner join"
					+" users on product.sellerid=?");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Register User
	public int registerUser(User object) throws UserAlreadyExistsException{
		int result = 0;
		try {
			viewProfile.setString(1, object.getUserName());
			ResultSet res = viewProfile.executeQuery();
			// java.util.Date date=new java.util.Date();   
			if(res.next()) {
				throw new UserAlreadyExistsException("Username already exists!");
			}
			// Set all parameters
			register.setString(1, object.getName());
			register.setDate(2, object.getDateOfBirth());
			register.setString(3, object.getEmail());
			register.setString(4, object.getPhoneNumber());
			register.setString(5, object.getUserName());
			register.setString(6, object.getPassword());
			register.setString(7, object.getAddress());
			register.setString(8, object.getTypeOfUser());
			register.setDouble(9, object.getWalletAmount());
			result = register.executeUpdate();
			}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Login User
	// Remaining: throw user not found exception
	public User loginUser(User object) throws IncorrectCredentialsException {
		User result = null;
		try {
			login.setString(1, object.getUserName());
			login.setString(2, object.getPassword());
			// Execute query
			ResultSet res = login.executeQuery();
			// java.util.Date date=new java.util.Date();   
			if(res.next()) {
				result = new User();
				lastloggedin.setString(1, object.getUserName());
				lastloggedin.executeUpdate();
				result.setTypeOfUser(res.getString(1));
			}
			else {
				throw new IncorrectCredentialsException("Username or password is incorrect");
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Add product
	public int addProduct(Product object) {
		int result = 0;
		try {
			addProduct.setString(1, object.getProductname());
			addProduct.setString(2, object.getCategory());
			addProduct.setString(3, object.getDescription());
			addProduct.setDouble(4, object.getActualprice());
			addProduct.setInt(5, object.getQuantity());
			addProduct.setString(6, object.getImage());
			// SellerID from session
			addProduct.setInt(7, object.getSellerid());
			// Execute Query
			result = addProduct.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	// Display seller information
	public User displaySellerInformation(User obj) {
		User temp = null;
		try {
		displaySeller.setInt(1, obj.getUserid());
		ResultSet res = displaySeller.executeQuery();
		if(res.next()) {
			temp = new User();
			temp.setName(res.getString(1));
			temp.setEmail(res.getString(2));
			temp.setPhoneNumber(res.getString(3));
			// temp.setLastloggedin(res.getDate(4));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return temp;
	}

	@Override
	public void retrieveProductsBySeller(int id) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		retrieveByProductsId.setInt(1,id);
		ResultSet res=retrieveByProductsId.executeQuery();
		while(res.next()) {
			result.add(res.getString(1));
		}
		
		
	}
}