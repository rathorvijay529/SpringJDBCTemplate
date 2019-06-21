package com.entity;

import java.util.List;

public class EmployeeEntity {
	private Integer employeeId;
	private String fname;
	private String lname;
	private Integer age;
	private String branchName;
	/*private List<Subject> subject;*/

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(Integer employeeId, String fname, String lname, Integer age, String branchName,
			List<Subject> subject) {
		super();
		this.employeeId = employeeId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.branchName = branchName;
		/*this.subject = subject;*/
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/*
	 * public List<Subject> getSubject() { return subject; }
	 * 
	 * public void setSubject(List<Subject> subject) { this.subject = subject; }
	 */
	
	

}
