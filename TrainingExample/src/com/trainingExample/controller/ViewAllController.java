package com.trainingExample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingExample.dao.EmpDAO;
import com.trainingExample.model.Employee;

@SuppressWarnings("serial")
public class ViewAllController extends HttpServlet {
	
	public ViewAllController() {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");

			EmpDAO ed = new EmpDAO();
			int pages = 0;
			int page = 0;
			if(request.getParameter("page") != null){
	            page = Integer.parseInt(request.getParameter("page"));
			}
			List<Employee> l = ed.allEmployee();
			List<Employee> al = new ArrayList<Employee>();
			int pageStart =  page*4;
			int pageEnd = Math.min(pageStart+4, l.size());//pageStart+4;
			for (int i = pageStart; i < pageEnd; i++) {
				al.add(l.get(i));
			}
			double d = l.size()/4f;
			if (d % 1 == 0){
				pages = (l.size()/4)-1;
			}
			else
				pages = (l.size()/4);
			System.out.println("list size:"+l.size()+" pages:"+pages);
			HttpSession session = request.getSession(false);
			session.setAttribute("list", al);
			session.setAttribute("pages", pages);
			RequestDispatcher rd = request.getRequestDispatcher("EmpAllView.jsp");
			rd.forward(request, response);
	}

}
