package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.model.Product;
import com.codefury.service.ServiceInterface;
import com.codefury.utility.ServiceFactory;

/**
 * Servlet implementation class scheduleAuction
 */
@WebServlet("/scheduleAuction")
public class scheduleAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServiceInterface serviceinterface = ServiceFactory.createServiceObject();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		/*
		 * CHECK IF USER IS SELLER TO GRANT ACCESS
		 * SESSION VARIABLE MUST BE PACKED WITH TYPE OF USER 
		 * 
		 * */
		if(request.getSession(false)==null) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please loggin into your SELLER account to access this page!! ');");
			out.println("location='index.html';");
			out.println("</script>");
		}
		
		String username=request.getParameter("username");
		String typeOfUser=request.getParameter("type");
		if(! "seller".equalsIgnoreCase(typeOfUser)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please loggin into your SELLER account to access this page!! ');");
			out.println("location='index.html';");
			out.println("</script>");
		}
		
		/*
		 * CALL TO SERVICE LAYER TO RETRIEVE PRODUCTS LISTED BY SELLER
		 * 
		 * 
		 * */
		
		try {
			List<Product> avail=new ArrayList<Product>();
			
		}catch(Exception e) {
			
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
