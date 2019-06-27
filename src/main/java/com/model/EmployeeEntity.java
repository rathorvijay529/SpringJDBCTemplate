package com.model;

import javax.persistence.Entity;


public class EmployeeEntity {

	private Integer id;
	private Integer age;
	private String firstName;
	private String lastName;
	private String address;
	private String bloodGroup;
	private String departmentName;
	private String employeeType;
	private AddressEntity addressDetails;
	private DepartmentEntity departmentDetails;

	public EmployeeEntity() {
	}
	

	public EmployeeEntity(Integer id, Integer age, String firstName, String lastName, String address, String bloodGroup,
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public AddressEntity getAddressDetails() {
		return addressDetails;
	}


	public void setAddressDetails(AddressEntity addressDetails) {
		this.addressDetails = addressDetails;
	}


	public DepartmentEntity getDepartmentDetails() {
		return departmentDetails;
	}


	public void setDepartmentDetails(DepartmentEntity departmentDetails) {
		this.departmentDetails = departmentDetails;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", bloodGroup=" + bloodGroup + ", departmentName=" + departmentName
				+ ", employeeType=" + employeeType + "]";
	}

	
	
	
}