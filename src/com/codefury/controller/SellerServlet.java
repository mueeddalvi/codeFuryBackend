package com.codefury.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.model.Product;

import com.codefury.service.ServiceInterface;
import com.codefury.utility.ServiceFactory;

public class SellerServlet extends HttpServlet {
		
	ServiceInterface serviceinterface;
	public SellerServlet() {
		serviceinterface = ServiceFactory.createServiceObject();
			}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add product
		Product object = new Product();
		serviceinterface.addProduct(object);
		
	}

}