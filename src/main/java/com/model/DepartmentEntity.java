package com.model;

public class DepartmentEntity {
	private Integer employeeId;
	private Integer departmentId;
	private String departmentName;
	private Integer numberOfEmployees;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(Integer employeeId, Integer departmentId, String departmentName, Integer numberOfEmployees) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public String toString() {
		return "Department [employeeId=" + employeeId + ", departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", NumberOfEmployees=" + numberOfEmployees + "]";
	}
	
	

}
