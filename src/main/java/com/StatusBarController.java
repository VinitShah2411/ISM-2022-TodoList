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


public class StatusBarController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		AddTaskDao taskDao = new AddTaskDao();
		ArrayList<AddTaskBean> tasks = taskDao.getMyTasks(userId);
		request.setAttribute("task", tasks);
		try {
		int h = 0, l = 0, m = 0, total = 0;
		for (AddTaskBean ts : tasks) {
			if (ts.getStatus().equals("pending")) {
				if (ts.getPriority().equals("high")) {
					h++;
					total++;
				}
				if (ts.getPriority().equals("medium")) {
					m++;
					total++;
				}
				if (ts.getPriority().equals("low")) {
					l++;
					total++;
				}
			}
			System.out.println(ts.getPriority());
		}

		int mp = 0, lp = 0, hp = 0;
		
			if (total != 0) {
				hp = h * 100 / total;
				mp = m * 100 / total;
				lp = l * 100 / total;
			}
			System.out.println("HP ->" + hp);
			System.out.println("LP ->" + lp);
			System.out.println("MP ->" + mp);
			
			
			int pending = 0, done = 0, totalStatus = 0;
			for (AddTaskBean ts : tasks) {
				if (ts.getStatus().equals("pending")) {
					pending++;
					totalStatus++;
				}

				if (ts.getStatus().equals("done")) {
					done++;
					totalStatus++;
				}
			}

			int pensts = 0, donests = 0;

			if (totalStatus!=0) {
				pensts = pending * 100 / totalStatus;
				donests = done * 100 / totalStatus;
			}

			System.out.println("Pending Status ->" + pensts);
			System.out.println("Done Status ->" + donests);

			request.setAttribute("pending", pensts);
			request.setAttribute("done", donests);

			
			request.setAttribute("HP", hp);
			request.setAttribute("MP", mp);
			request.setAttribute("LP", lp);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException in ListTaskCintroller");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception in ListTaskCintroller");
			e.printStackTrace();
		}
		request.getRequestDispatcher("TodoList.jsp").forward(request, response);
	}
}