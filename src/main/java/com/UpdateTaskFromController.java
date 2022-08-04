package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddTaskBean;
import dao.AddTaskDao;

public class UpdateTaskFromController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddTaskBean task = new AddTaskBean();
		task.setTaskname(request.getParameter("taskname"));
		task.setDescription(request.getParameter("description"));
		task.setStatus(request.getParameter("status"));
		task.setPriority(request.getParameter("priority"));
		task.setDate(request.getParameter("date"));
		task.setTaskId(Integer.parseInt(request.getParameter("taskid")));//ahiya zero aave che 
		AddTaskDao addtaskDao = new AddTaskDao();
		if(addtaskDao.UpdateTask(task)) {
			request.setAttribute("message", "Updated Successfully");
		}else {
			request.setAttribute("message", "Some error occured");
		}
		request.getRequestDispatcher("ListAllTaskController").forward(request, response);
	}
	}
