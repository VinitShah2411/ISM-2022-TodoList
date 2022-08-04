package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import dao.CustomerDao;

public class UpdatePasswordController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBean customerBean = new CustomerBean();
		HttpSession session = request.getSession();
		customerBean.setMnumber((String) session.getAttribute("mnumber"));
		customerBean.setPassword(request.getParameter("password"));
//		System.out.println(customerBean);
		CustomerDao customerDao = new CustomerDao();
		
		if(customerDao.updatePassword(customerBean)) {
			request.setAttribute("message", "Password Updated");
		}
		else {
			request.setAttribute("message", "SWR in updatepassword con");
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}
		

