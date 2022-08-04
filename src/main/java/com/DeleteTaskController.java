package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddTaskDao;

public class DeleteTaskController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int taskId = Integer.parseInt(request.getParameter("taskId"));
//		System.out.println(taskId);
		AddTaskDao addtaskDao = new AddTaskDao();
		if(addtaskDao.deleteTask(taskId))
		{
			request.setAttribute("msg","Task Deleted Successfully");
		}
		else
		{
			request.setAttribute("msg","Some error Occured in Dao");
		}
		request.getRequestDispatcher("ListAllTaskController").forward(request, response);
	}

}
