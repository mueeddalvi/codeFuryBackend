package com.codefury.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codefury.exception.IncorrectCredentialsException;
import com.codefury.exception.UserAlreadyExistsException;
import com.codefury.model.Auction;
import com.codefury.model.Product;
import com.codefury.model.User;
import com.codefury.service.ServiceInterface;
import com.codefury.utility.ServiceFactory;

public class GlobalServlet extends HttpServlet {

	ServiceInterface serviceinterface;

	public GlobalServlet() {
		// Trial t = new Trial();
		// t.timer();
		// ServiceInterface point it to ServiceFactory
		serviceinterface = ServiceFactory.createServiceObject();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("ac");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Register
		if (option.equalsIgnoreCase("register")) {
			String name = request.getParameter("name");
			String dateOfBirth = request.getParameter("dob");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phone");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String typeOfUser = request.getParameter("typeOfUser");
			String wallet = request.getParameter("wallet");

			java.sql.Date dob = java.sql.Date.valueOf(dateOfBirth);
			double walletAmount = Double.parseDouble(wallet);

			User object = new User();
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
				if (result > 0) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='index.jsp';");
					out.println("</script>");
				}
			} catch (UserAlreadyExistsException e) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User Already exists');");
				out.println("location='index.jsp';");
				out.println("</script>");
			}
		}

		// Login
		if (option.equalsIgnoreCase("login")) {
			// Get data from POST
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			// Create object
			User object = new User();
			object.setUserName(userName);
			object.setPassword(password);
			// Call service layer
			try {
				User result = serviceinterface.login(object);
				if (result != null) {
					// Set into session
					HttpSession session = request.getSession();
					session.setAttribute("user", result.getUserid());

					String path = "/" + result.getTypeOfUser() + ".jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
					rd.include(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Something went wrong');");
					out.println("location='login.jsp';");
					out.println("</script>");
				}
			} catch (IncorrectCredentialsException e) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Incorrect username or password');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		}

		// Add product
		if (option.equalsIgnoreCase("addproduct")) {

			// Get id from session
			HttpSession session = request.getSession(false);
			Integer userid = (Integer) session.getAttribute("user");
			System.out.println(userid);

			// Check type of user is seller
			String typeOfUser = request.getParameter("type");
			if (!"seller".equalsIgnoreCase(typeOfUser)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Please loggin into your SELLER account to access this page!!');");
				out.println("location='index.html';");
				out.println("</script>");
			}

			String category = request.getParameter("category");
			String description = request.getParameter("description");
			String productname = request.getParameter("productname");
			String actualPrice = request.getParameter("price");
			String Quantity = request.getParameter("quantity");
			String image = request.getParameter("image");

			// Parse
			double actualprice = Double.parseDouble(actualPrice);
			int quantity = Integer.parseInt(Quantity);

			// Add product
			Product object = new Product();
			object.setProductname(productname);
			object.setCategory(category);
			object.setDescription(description);
			object.setActualprice(actualprice);
			object.setQuantity(quantity);
			object.setSellerid(userid);
			// Figure out image again
			object.setImage(image);

			int result = serviceinterface.addProduct(object);
			if (result > 0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Seller.jsp");
				rd.forward(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		}

		// Display seller information
		// This function should be called when the page loads
		if (option.equalsIgnoreCase("displayseller")) {
			// Get id from session
			HttpSession session = request.getSession(false);
			Integer userid = (Integer) session.getAttribute("user");
			// System.out.println(userid);
			// Create data object

			// Check type of user is seller
			String typeOfUser = request.getParameter("type");
			if (!"seller".equalsIgnoreCase(typeOfUser)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Please loggin into your SELLER account to access this page!!');");
				out.println("location='index.html';");
				out.println("</script>");
			}

			User object = new User();
			object.setUserid(userid);
			User result = serviceinterface.displaySeller(object);
			if (result != null) {
				System.out.println(result.getName() + " " + result.getName() + " " + result.getPhoneNumber() + " "
						+ result.getLastloggedin());
			}
		}

		if (option.equalsIgnoreCase("displaysellerproducts")) {
			// Get id from session
			//HttpSession session = request.getSession(false);
			//Integer userid = (Integer) session.getAttribute("user");
			// System.out.println(userid);
			// Create data object

			// Check type of user is seller
			String typeOfUser = request.getParameter("type");
			if (!"seller".equalsIgnoreCase(typeOfUser)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Please loggin into your SELLER account to access this page!!');");
				out.println("location='index.html';");
				out.println("</script>");
			}

			String sellId = request.getParameter("userId");
			int sid = Integer.parseInt(sellId);
			boolean result = serviceinterface.getProducts(sid);
			if (result != false) {
				request.getSession(true);
			}
		}

		if (option.equalsIgnoreCase("scheduleauction")) {
			// System.out.println("Inside schedule now");
			HttpSession session = request.getSession(false);
			int userid = (Integer) session.getAttribute("user");
			// System.out.println(userid);

			// Check type of user is seller
			String typeOfUser = request.getParameter("type");
			if (!"seller".equalsIgnoreCase(typeOfUser)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Please loggin into your SELLER account to access this page!!');");
				out.println("location='index.html';");
				out.println("</script>");
			}

			String productname = request.getParameter("productname");
			String minbid = request.getParameter("minbid");
			String bidstart = request.getParameter("bidstart");
			String bidend = request.getParameter("bidend");

			// Parse
			double minBid = Double.parseDouble(minbid);
			java.sql.Date bidStart = java.sql.Date.valueOf(bidstart);
			java.sql.Date bidEnd = java.sql.Date.valueOf(bidend);

			// Object and add

			User object = new User();
			object.setUserid(userid);

			Auction auctionobject = new Auction();
			auctionobject.setProductname(productname);
			auctionobject.setMinimumbid(minBid);
			auctionobject.setBidstart(bidStart);
			auctionobject.setBidend(bidEnd);

			// Pass to service
			int result = serviceinterface.scheduleAuction(auctionobject, object);
			if (result > 0)
				System.out.println("Auction scheduled");
			else
				System.out.println("Oops!");
		}
	}
}