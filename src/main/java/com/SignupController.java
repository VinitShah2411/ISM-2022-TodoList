package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerBean;
import dao.CustomerDao;



public class SignupController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mnumber = request.getParameter("mnumber");
//		System.out.println(mnumber);
		CustomerDao customerDao = new CustomerDao();
		
		CustomerBean customerBean = new CustomerBean();
		customerBean.setFirstName(firstName);
		customerBean.setEmail(email);
		customerBean.setPassword(password);
		customerBean.setMnumber(mnumber);
		customerDao.insertUser(customerBean);
//		request.setAttribute("msg","Signup Done" );
//		request.getRequestDispatcher("Login.jsp").forward(request, response);;
		response.sendRedirect("Login.jsp");
	}
		
	}


