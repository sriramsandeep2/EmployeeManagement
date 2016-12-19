package com.trainingExample.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.trainingExample.dao.EmpDAO;
import com.trainingExample.model.Employee;

@SuppressWarnings("serial")
@MultipartConfig
public class RegisterEmployeeController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p align=center>Employee registerd succesfully</p>");
   
		//String DRIVER_NAME = getServletContext().getInitParameter("DRIVER_NAME");

		// fetching from user
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String depart = request.getParameter("depart");
		Part photoPart = request.getPart("photo");
		Part resumePart = request.getPart("resume");
		InputStream photoStream = null;
		InputStream resumeStream = null;
		if (photoPart != null) {
			photoStream = photoPart.getInputStream();
		}
		if (resumePart != null) {
			resumeStream = resumePart.getInputStream();
		}
		
		// loading into bean
		Employee emp = new Employee();
		emp.setfName(fname);
		emp.setlName(lname);
		emp.setAddress(address);
		emp.setPhone(phone);
		emp.setEmail(email);
		emp.setDepartment(depart);
		emp.setPhotoIn(photoStream);
		emp.setResumeIn(resumeStream);
		EmpDAO ed = new EmpDAO();
		ed.insert(emp);

		RequestDispatcher rd = request.getRequestDispatcher("EmpRegister.jsp");
		rd.include(request, response);
	}

}
