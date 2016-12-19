package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String admin = request.getParameter("admin");
		String pass = request.getParameter("password");
		
		if (admin.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password")) {
			chain.doFilter(request, response);
			
		} else {
			out.println("<p align=center>Please login again</p>");	
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);

		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
