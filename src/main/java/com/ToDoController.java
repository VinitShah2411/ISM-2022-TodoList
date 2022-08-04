package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.AddTaskBean;
import dao.AddTaskDao;


public class ToDoController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		int userId = (int) session.getAttribute("userId");
	//	System.out.println(userId);
		
		AddTaskDao addtaskDao=new AddTaskDao();
		ArrayList<AddTaskBean> tasks = addtaskDao.getMyTasks(userId);
		request.setAttribute("tasks",tasks);
		System.out.println(tasks);
		RequestDispatcher rd = null;
		rd=	request.getRequestDispatcher("ListTask.jsp");
		rd.forward(request, response);
		
		/*
	 * AddTaskBean addtask = new AddTaskBean(); addtask.setTaskname(taskname);
	 * addtask.setStatus(status); addtask.setUserid(userId);
	 * 
	 * AddTaskDao addtaskDao = new AddTaskDao(); addtaskDao.A(addtask);
	 * 
	 * response.sendRedirect("ListTaskController");
	 */
	}

}
