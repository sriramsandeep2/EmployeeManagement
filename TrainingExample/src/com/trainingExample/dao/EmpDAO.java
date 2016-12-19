package com.trainingExample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainingExample.model.Employee;

public class EmpDAO {

	String insertQ = "insert into Employee(fname, lname, address, phone, email, depart, photo, resume) values(?,?,?,?,?,?,?,?)";
	String searchQ = "select * from employee where (fname = ? OR lname = ? OR address = ? OR phone = ? OR email = ? OR depart = ?) ";
	String viewAllQ = "select * from employee";
	String deleteQ = "delete from employee where id = ?";
	String update_searchQ = "select * from employee where id = ?";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DBUtil db = new DBUtil();
	

	public void insert(Employee emp) {
		
		try {
			con = db.getConnection();
			ps = con.prepareStatement(insertQ);
			ps.setString(1, emp.getfName());
			ps.setString(2, emp.getlName());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getDepartment());
			if (emp.getPhotoIn() != null)
				ps.setBlob(7, emp.getPhotoIn());
			if (emp.getResumeIn() != null)
				ps.setBlob(8, emp.getResumeIn());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Employee> allEmployee() {
		List<Employee> l = new ArrayList<Employee>();
		try {
			con = db.getConnection();
			ps = con.prepareStatement(viewAllQ);

			rs = ps.executeQuery();
			while (rs.next()) {
				Employee ep = new Employee();
				ep.setId(rs.getInt(1));
				ep.setfName(rs.getString(2));
				ep.setlName(rs.getString(3));
				ep.setAddress(rs.getString(4));
				ep.setPhone(rs.getString(5));
				ep.setEmail(rs.getString(6));
				ep.setDepartment(rs.getString(7));
				l.add(ep);
			}
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;

	}
	

	public List<Employee> searchEmployee(Employee emp) {
		List<Employee> l = new ArrayList<Employee>();
		try {
			con = db.getConnection();
			ps = con.prepareStatement(searchQ);
			ps.setString(1, emp.getfName());
			ps.setString(2, emp.getlName());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getDepartment());

			rs = ps.executeQuery();
			while (rs.next()) {
				Employee ep = new Employee();
				ep.setId(rs.getInt(1));
				ep.setfName(rs.getString(2));
				ep.setlName(rs.getString(3));
				ep.setAddress(rs.getString(4));
				ep.setPhone(rs.getString(5));
				ep.setEmail(rs.getString(6));
				ep.setDepartment(rs.getString(7));
				ep.setPhotoOut(rs.getBlob(8));
				l.add(ep);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;

	}

	public void delete(String id) {
		
		try {
			con = db.getConnection();
			ps = con.prepareStatement(deleteQ);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateEmployee(Employee emp, int id) {
		String update_updateQ = "update Employee set fname=?, lname=?, address=?, phone=?, email=?, depart=? where id="
				+ id;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			ps = con.prepareStatement(update_updateQ);
			ps.setString(1, emp.getfName());
			ps.setString(2, emp.getlName());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getDepartment());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Employee> updateEmployeeView(String id) {

		List<Employee> l = new ArrayList<Employee>();

		try {
			con = db.getConnection();
			ps = con.prepareStatement(update_searchQ);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee ep = new Employee();
				ep.setId(rs.getInt(1));
				ep.setfName(rs.getString(2));
				ep.setlName(rs.getString(3));
				ep.setAddress(rs.getString(4));
				ep.setPhone(rs.getString(5));
				ep.setEmail(rs.getString(6));
				ep.setDepartment(rs.getString(7));
				l.add(ep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return l;

	}

}
