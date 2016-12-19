package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingExample.dao.EmpDAO;
import com.trainingExample.model.Employee;

@SuppressWarnings("serial")
public class DeleteEmployeeController extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		EmpDAO ed = new EmpDAO();
		List<Employee> l = ed.updateEmployeeView(id);
		int id_n = 0;
		for(Employee ep: l){
			id_n = ep.getId();
		}
		if(id_n == 0){
			out.println("<p align=center>Id not found.Please enter another Id.</p>");
			RequestDispatcher rr = request.getRequestDispatcher("EmpDelete.jsp");
			rr.include(request, response);
		}
		else {
			ed.delete(id);
			out.println("Id "+id+" succesfully deleted");
		
			RequestDispatcher rd = request.getRequestDispatcher("EmpDelete.jsp");
			rd.include(request, response);
			
		}
		
	}
}
