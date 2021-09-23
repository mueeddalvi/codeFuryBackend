package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.User;
import com.codefury.service.ServiceInterface;
import com.codefury.utility.ServiceFactory;

public class RegisterLoginServlet extends HttpServlet {
	
	ServiceInterface serviceinterface;
	
	
	public RegisterLoginServlet() {
		// Trial t = new Trial();
		// t.timer();
		// ServiceInterface point it to ServiceFactory
		serviceinterface = ServiceFactory.createServiceObject();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		String option=request.getParameter("ac");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// Register
		if(option.equalsIgnoreCase("register")) {
			String name=request.getParameter("name");
			String dateOfBirth = request.getParameter("dob");
			String email=request.getParameter("email");
			String phoneNumber = request.getParameter("phone");
			String userName = request.getParameter("username");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String typeOfUser = request.getParameter("typeOfUser");
			String wallet = request.getParameter("wallet");
			
			// Parse
			/*
			Date dob = null;
			try {
				dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
			}
			catch(ParseException e1) {
				e1.printStackTrace();
			}
			*/
			java.sql.Date dob = java.sql.Date.valueOf(dateOfBirth);
			double walletAmount = Double.parseDouble(wallet); 
			
			User object=new User();
			object.setName(name);
			object.setDateOfBirth(dob);
			object.setEmail(email);
			object.setPhoneNumber(phoneNumber);
			object.setUserName(userName);
			object.setPassword(password);
			object.setAddress(address);
			object.setTypeOfUser(typeOfUser);
			object.setWalletAmount(walletAmount);

			int result = 0;
			try {
				result = serviceinterface.register(object);
				if(result>0){
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.html");
					rd.forward(request, response);
				}	
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='index.html';");
					out.println("</script>");
				}
			} 
			catch (UserAlreadyExistsException e) {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('User Already exists');");
				 out.println("location='index.html';");
				 out.println("</script>");
			}
		}
		
		// Login
		if(option.equalsIgnoreCase("login")) {
			// Get data from POST
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			// Create object
			User object = new User();
			object.setUserName(userName);
			object.setPassword(password);
			// Call service layer
			try {
				User result = serviceinterface.login(object);
				if(result != null) {
					request.getSession().getLastAccessedTime();
					
					String path ="/"+result.getTypeOfUser()+".html";
					RequestDispatcher rd=getServletContext().getRequestDispatcher(path);
					rd.include(request, response);
				}
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='index.html';");
					out.println("</script>");
				}
			} 
			catch (IncorrectCredentialsException e) {
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Incorrect username or password');");
				 out.println("location='index.html';");
				 out.println("</script>");
			}
		}
	}
}