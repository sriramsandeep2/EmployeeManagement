package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//ServletConfig cof = getServletConfig();
		//getServletConfig().getInitParameter("");
		String admin = request.getParameter("admin");
		String pass = request.getParameter("password");

		if (admin.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("password")) {
			//Creating session
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);


		} else {
			out.println("Invalid details....login again");
			RequestDispatcher rr = request.getRequestDispatcher("index.jsp");
			rr.include(request, response);

		}
	}

}
