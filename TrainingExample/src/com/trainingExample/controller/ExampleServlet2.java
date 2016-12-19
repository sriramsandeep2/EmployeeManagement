package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ExampleServlet2 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ServletContext sc = getServletContext();
		
		PrintWriter out = response.getWriter();
		out.println("Driver name="+sc.getInitParameter("DRIVER_NAME"));
		out.println("<BR>"+"DB URL name="+sc.getInitParameter("DB_URL"));
		out.println("<BR>"+"DB user name="+sc.getInitParameter("DB_NAME"));
		out.println("<BR>"+"DB pwd="+sc.getInitParameter("DB_PASSWORD"));
	
		out.print("<BR>"+getServletConfig().getInitParameter("specific"));
		
	}

}
