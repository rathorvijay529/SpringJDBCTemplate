package com.model;

import javax.persistence.Entity;

@Entity
public class Employee {
	private int id;
	private int age;
	private String firstName;
	private String lastName;
	private String address;
	private String bloodGroup;
	private String departmentName;
	private String employeeType;

	public Employee() {
	}

	public Employee(int id, int age, String firstName, String lastName, String address, String bloodGroup,
			String departmentName, String employeeType) {
		super();
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.departmentName = departmentName;
		this.employeeType = employeeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", bloodGroup=" + bloodGroup + ", departmentName=" + departmentName
				+ ", employeeType=" + employeeType + "]";
	}

}
