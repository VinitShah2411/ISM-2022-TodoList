
package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.CustomerDao;

public class SignupFilter implements Filter {



		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			System.out.println("doFilter From SignupFilter");
			boolean isError = false;
			// validation
			String firstName = request.getParameter("firstName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String mnumber = request.getParameter("mnumber");
			
			System.out.println(firstName);
			System.out.println(email);
			
			if (firstName == null || firstName.trim().length() == 0) {
				isError = true;
				request.setAttribute("firstNameError", "<font color='red'> Please Enter FirstName </Font>");
			}
			else
			{
				request.setAttribute("firstNameValue", firstName);
			}
			
			  if (mnumber == null || mnumber.trim().length() ==0) 
			  { 
				  isError = true;
				  request.setAttribute("numberError", "<font color='red'> Please Enter Number </Font>"); 
			  } else if(mnumber.length()<5) 
			  	{ 
				  isError = true; 
				  request.setAttribute("numberError", "<font color='red'> Please Enter 5 Digit number </Font>"); 
				 } else 
				 {
					 request.setAttribute("numberValue", mnumber); 
				}
			 
			if (email == null || email.trim().length() == 0) {
				isError = true;
				request.setAttribute("emailError", "<font color='red'> Please Enter Email </Font>");
			}
			else
			{
				request.setAttribute("emailValue", email);
			}
			if (password == null || password.trim().length() ==0) {
				isError = true;
				request.setAttribute("passwordError", "<font color='red'> Please Enter password </Font>");
			}
			else if(password.length()<4) 
			{
				isError = true;
				request.setAttribute("passwordError", "<font color='red'> Please Enter 4 Digit password </Font>");
			}
			else
			{
				request.setAttribute("passwordValue", password);
			}
			
			CustomerDao customerDao = new CustomerDao();
			Boolean numbercheck = customerDao.CheckDuplicateNumber(mnumber); 
			if(numbercheck)
			{
				request.setAttribute("samenumber", "<font color='red'> Duplicate Number Found Enter New One </Font>");
				isError=true;
			}
			Boolean customer = customerDao.CheckDuplicateEmail(email);
			if (customer) 
			{
				request.setAttribute("sameemail", "<font color='red'> Duplicate Email Found Enter New One </Font");
				isError=true;
			}
			if (isError)
			{
				request.getRequestDispatcher("Signup.jsp").forward(request,response); 
			} else 
			{
				chain.doFilter(request, response); 
			}
		}
			  

		public void init(FilterConfig config) throws ServletException 
		{
			System.out.println("SignupFIlterInit()");
		}

		public void destroy() {
			System.out.println("SignupFilterDestroy()");	
		}

	}


