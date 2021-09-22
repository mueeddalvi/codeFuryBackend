package com.codefury.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.exceptions.UserAlreadyExists;
import com.codefury.model.User;
import com.codefury.service.UserImpl;
import com.codefury.service.UserService;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		long phone=Long.parseLong(request.getParameter("phone"));
		LocalDate dob=LocalDate.parse(request.getParameter("dOb"));
		String type=request.getParameter("typeOfUser");
		String address=request.getParameter("address");
		double wallet=Double.parseDouble(request.getParameter("wallet"));
		
		User user=new User(name, mail, username, password, address, type, wallet, phone, dob);
		UserService userservice=new UserImpl();
		try {
			/*
			 * IF SUCCESSFUL REDIRECTS TO HOME PAGE 
			 * APPROPRIATE MESSAGE IN AN ALERT BOX NEEDS TO BE DISPLAYED AFTER SUCCESSFUL INSERTION
			 * 
			 * IF FAILED --> MESSAGE SHOULD BE DISPLAYED IN AN ALERT BOX 
			 * */
			int res=userservice.store(user);
			if(res>0) {
				request.getSession(true).setAttribute("user", user);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			else {
				throw new Exception("Something went wrong!!");
			}
			
		} catch (UserAlreadyExists uae) {
			// TODO Auto-generated catch block
			response.getWriter().write(uae.getMessage());
		}catch(Exception e){
			response.getWriter().write(e.getMessage());

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
