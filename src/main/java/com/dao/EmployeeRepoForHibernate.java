package com.dao;

import java.util.List;

import com.entity.Employee;
import com.model.EmployeeMO;

public interface EmployeeRepoForHibernate {

	public Employee updateEmployeeForHibernate(EmployeeMO emp);

	public List<Employee> getEmployees();

	public Integer delete(Integer id);

	public Employee save(Employee emp);

	public Employee getEmployee(Integer id);
}
