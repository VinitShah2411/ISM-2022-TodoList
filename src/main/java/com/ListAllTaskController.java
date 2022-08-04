package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddTaskBean;
import dao.AddTaskDao;


public class ListAllTaskController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		AddTaskDao addtaskDao = new AddTaskDao();
		ArrayList<AddTaskBean> tasks  = addtaskDao.getMyTasks(userId);
		
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("ListAllTask.jsp").forward(request, response);
	}

}
