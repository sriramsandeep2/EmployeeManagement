package com.trainingExample.model;

import java.io.InputStream;
import java.sql.Blob;

public class Employee {
	private int id;
	private String fName;
	private String lName;
	private String address;
	private String phone;
	private String email;
	private String department;
	private InputStream photoIn;
	private InputStream resumeIn;
	private Blob photoOut;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public InputStream getPhotoIn() {
		return photoIn;
	}
	public void setPhotoIn(InputStream photoIn) {
		this.photoIn = photoIn;
	}
	public Blob getPhotoOut() {
		return photoOut;
	}
	public void setPhotoOut(Blob photoOut) {
		this.photoOut = photoOut;
	}
	public InputStream getResumeIn() {
		return resumeIn;
	}
	public void setResumeIn(InputStream resumeIn) {
		this.resumeIn = resumeIn;
	}
	

}
