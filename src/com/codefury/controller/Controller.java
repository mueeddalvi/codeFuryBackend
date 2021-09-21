package com.codefury.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codefury.dao.DAO;
import com.codefury.dao.DAOInterface;
import com.codefury.model.Product;
import com.codefury.model.User;

@WebServlet("/")
public class Controller extends HttpServlet {

	DAOInterface dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new DAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		System.out.println(requestURI);

		switch (requestURI) {
		case "/codeFuryBackend/seller":
			String uId = req.getParameter("userId");
			int id = Integer.parseInt(uId);
			try {
				User user = dao.displaySellerInfo(id);
				req.getSession(true).setAttribute("user", user);
				req.getRequestDispatcher("/seller.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				resp.getWriter().write(e.getMessage());
			}
			break;

		case "/codeFuryBackend/seller/addProduct":
			try {
				Product prod = null;
				int val = dao.addProduct(prod);
				resp.getWriter().write(val);
			} catch (Exception e) {

				e.printStackTrace();
				resp.getWriter().write(e.getMessage());
			}

		default:
			resp.sendError(404, requestURI + " Not Found");
			break;
		}

	}

}
