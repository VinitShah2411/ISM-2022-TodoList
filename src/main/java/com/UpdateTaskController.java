package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddTaskBean;
import dao.AddTaskDao;

public class UpdateTaskController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		AddTaskDao addtaskDao = new AddTaskDao();
		AddTaskBean task = addtaskDao.getTaskByTaskId(taskId);
//		task.setTaskId(Integer.parseInt(request.getParameter("taskid")));
		request.setAttribute("task", task);
		request.getRequestDispatcher("UpdateTask.jsp").forward(request, response);
	}
}