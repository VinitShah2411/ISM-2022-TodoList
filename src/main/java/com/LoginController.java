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

public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		int isactive = request.getParameter(isactive);
		CustomerDao customerDao = new CustomerDao();

		CustomerBean customer = customerDao.login(email, password);
//		System.out.println(customer);

		RequestDispatcher rd = null;

		if (customer == null) {
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		}

		

		else {
			HttpSession session = request.getSession();
			session.setAttribute("userId", customer.getUserId());
			System.out.println(customer.getUserId());
			System.out.println(customer.getIsactive());
//			request.setAttribute(email,"email");
			if (customer.getUserType().equals("customer") && customer.getIsactive() == 1) {
				rd = request.getRequestDispatcher("ToDoList.jsp");
			} 
			else if (customer.getIsactive() == 0 && customer.getUserType().equals("customer")) {
				request.setAttribute("errorMsg1", "Account is disabled");
				rd = request.getRequestDispatcher("Login.jsp");
			}
			else {
				rd = request.getRequestDispatcher("404.jsp");
			}

		}
		rd.forward(request, response);
	}
}
