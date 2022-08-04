package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

public class AccountDisableController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.disable(userId))
		{
			request.setAttribute("msg","Account Disable Successfully");
		}
		else
		{
			request.setAttribute("msg","Some error Occured in Dao");
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}


