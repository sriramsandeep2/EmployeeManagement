package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/country")
public class CountryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<body bgcolor=#88ff4d>");
		out.println("<br><br>");
		out.println("<h1 align=center> Hai Indian. <br> How are you?");
	}

	@Override
	public void init() throws ServletException {
		
	}
	
	
	

}
