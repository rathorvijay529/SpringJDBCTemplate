package com.model;

public class Employee {
	private Integer employeeId;
	private String fname;
	private String lname;

	public Employee(Integer employeeId, String fname, String lname) {
		super();
		this.employeeId = employeeId;
		this.fname = fname;
		this.lname = lname;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
