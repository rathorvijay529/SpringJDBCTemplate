package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5255046716730821811L;

	@Id
	@Column(name = "Emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Emp_age")
	private int age;
	@Column(name = "Emp_firstName")
	private String firstName;
	@Column(name = "Emp_lastName")
	private String lastName;
	@Column(name = "Emp_address")
	private String address;
	@Column(name = "Emp_bloodGroup")
	private String bloodGroup;
	@Column(name = "Emp_departmentName")
	private String departmentName;
	@Column(name = "Emp_employeeType")
	private String employeeType;

	public Employee() {
	}

	public Employee(int id, int age, String firstName, String lastName,
			String address, String bloodGroup, String departmentName,
			String employeeType) {
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
		return "Employee [id=" + id + ", age=" + age + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address
				+ ", bloodGroup=" + bloodGroup + ", departmentName="
				+ departmentName + ", employeeType=" + employeeType + "]";
	}

}
