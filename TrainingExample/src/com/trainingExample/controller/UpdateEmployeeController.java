package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateEmployeeController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String san = (String)request.getAttribute("san");
		EmpDAO ed = new EmpDAO();
		List<Employee> l = ed.updateEmployeeView(id);
		int id_n = 0;
		for(Employee ep: l){
			id_n = ep.getId();
		}
		if(id_n == 0){
			out.println("<p align=center>Id not found.Please enter another Id.</p>");
			RequestDispatcher rr = request.getRequestDispatcher("EmpUpdate.jsp");
			rr.include(request, response);
		}
		else{
			HttpSession session = request.getSession();
			RequestDispatcher rd = request.getRequestDispatcher("EmpUpdateView.jsp");
			if (san != null) {
				out.println("Succesfully updated");
				rd.include(request, response);
			}
			else {
				rd.forward(request, response);
			}	
			
			for (Employee ep : l) {
				session.setAttribute("id", ep.getId());
				session.setAttribute("fname", ep.getfName());
				session.setAttribute("lname", ep.getlName());
				session.setAttribute("add", ep.getAddress());
				session.setAttribute("phone", ep.getPhone());
				session.setAttribute("email", ep.getEmail());
				session.setAttribute("dept", ep.getDepartment());
			}
		}
		
	}

}
