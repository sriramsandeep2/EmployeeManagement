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
public class SearchEmployeeController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		
		// fetching user input
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String depart = request.getParameter("depart");
		
		// preparating a bean from user input
		Employee emp = new Employee();
		emp.setfName(fname);
		emp.setlName(lname);
		emp.setAddress(address);
		emp.setPhone(phone);
		emp.setEmail(email);
		emp.setDepartment(depart);
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rr = request.getRequestDispatcher("EmpSearch.jsp");
		if(fname=="" && lname=="" && address=="" && phone=="" && email=="" && depart==""){
			out.println("<p align=center>Please enter atleast one field</p>");
			rr.include(request, response);
		}else{
			try {
			EmpDAO ed = new EmpDAO();
			//Blob b=null;
			List<Employee> l = ed.searchEmployee(emp);
			if (l.isEmpty()) {
				System.out.println("null+null+1");
				out.println("<p align=center>No Matching found</p>");
				rr.include(request, response);
				System.out.println("null+null+2");
			}
			//BufferedImage bi = new 
			/*for (Employee employee : l) {
				b= employee.getPhotoOut();
			}
			FileOutputStream f = new FileOutputStream("");*/
			
			//InputStream in = b.getBinaryStream();  
			//BufferedImage image = ImageIO.read(in);
			HttpSession session = request.getSession(true);
			session.setAttribute("list", l);
			session.setAttribute("emp", emp);
			//session.setAttribute("image", image);
			System.out.println("last");
			RequestDispatcher rd = request.getRequestDispatcher("SearchHome.jsp");
			rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					
				}
			
		}	
		
		
	}
	

}
