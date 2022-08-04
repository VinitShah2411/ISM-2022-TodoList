package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddTaskBean;
import dao.AddTaskDao;


public class AddTaskController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskname = request.getParameter("taskname");
		String description = request.getParameter("description");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		String date = request.getParameter("date");
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
//		System.out.println(taskname);
//		System.out.println(description);
//		System.out.println(priority);
//		System.out.println(status);
		AddTaskDao addtaskDao = new AddTaskDao();
		AddTaskBean addtaskBean = new AddTaskBean();
		addtaskBean.setTaskname(taskname);
		addtaskBean.setDescription(description);
		addtaskBean.setPriority(priority);
		addtaskBean.setStatus(status);
		addtaskBean.setDate(date);
		addtaskBean.setUserid(userId);
		System.out.print("task");
		addtaskDao.insertTask(addtaskBean);
		request.setAttribute("msg","Task added");
		
		response.sendRedirect("AddTask.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("AddTask.jsp");
//		rd.forward(request, response);
	}
}
