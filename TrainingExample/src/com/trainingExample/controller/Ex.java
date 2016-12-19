package com.trainingExample.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ex")
public class Ex extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Using Locale
		//Locale.setDefault(new Locale("en","US"));
		//System.out.println("Ex: "+Locale.getDefault().getCountry());
		
		// Using session
		Locale locale = new Locale("en", "IN");
		HttpSession session = request.getSession();
		session.setAttribute("Locale", locale);
		RequestDispatcher rd = request.getRequestDispatcher("country");
		rd.include(request, response);
	}
	

}
