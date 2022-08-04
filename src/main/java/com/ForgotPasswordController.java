package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import dao.CustomerDao;


public class ForgotPasswordController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String mnumber = request.getParameter("mnumber");
		HttpSession session = request.getSession();
		session.setAttribute("mnumber", mnumber);
		System.out.println(email);
		System.out.println(mnumber);

		CustomerDao customerDao = new CustomerDao();
		CustomerBean customer = customerDao.ForgotPassword(email,mnumber);
		RequestDispatcher rd = null;

		if (customer == null) 
		{
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("ForgotPassword.jsp");
		} 
			
		/*
		 * else if (customer.getUserType().equals("customer")) { //
		 * request.setAttribute("mnumber", mnumber); rd =
		 * request.getRequestDispatcher("UpdatePassword.jsp"); }
		 */
		else {
			rd = request.getRequestDispatcher("UpdatePassword.jsp");
		}
		 rd.forward(request, response);
	}
}
		




