package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddTaskDao;

public class TaskStatusController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int taskId = Integer.parseInt(request.getParameter("taskId"));
		AddTaskDao addtaskDao = new AddTaskDao();
		
		if(addtaskDao.Statusupdate(taskId))
		{
			request.setAttribute("msg","Task Status Updated Successfully");
		}
		else
		{
			request.setAttribute("msg","Some error Occured in Dao");
		}
		request.getRequestDispatcher("ListAllTaskController").forward(request, response);
	}

	}


