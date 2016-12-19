package com.trainingExample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingExample.dao.EmpDAO;
import com.trainingExample.model.Employee;

@SuppressWarnings("serial")
public class UpdateEmployeeController1 extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String depart = request.getParameter("depart");
		
		
		int idi = Integer.parseInt(id);
		
		Employee emp = new Employee();
		emp.setId(idi);
		emp.setfName(fname);
		emp.setlName(lname);
		emp.setAddress(address);
		emp.setPhone(phone);
		emp.setEmail(email);
		emp.setDepartment(depart);
		
		EmpDAO ed = new EmpDAO();
		ed.updateEmployee(emp, idi);
		
		out.println("Succesfully updated");
		request.setAttribute("san", "san");
		RequestDispatcher rd = request.getRequestDispatcher("Update");
		rd.forward(request, response);
		
	}


}
