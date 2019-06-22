package com.service;

import java.util.List;

import com.entity.EmployeeEntity;
import com.model.Employee;

public interface EmployeeService {
	public Employee processGetEmployee(Integer id);

	public List<Employee> processGetEmployees();

	public void processDelete(Integer id);

	public void processSave(EmployeeEntity emp);

	public String processUpdateEmployee(EmployeeEntity emp);

	public void processSaveUsingNamedParameter(EmployeeEntity employeeEntity);

	public void processDeleteUsingNamedParameter(Integer id);
	
	public Employee processGetEmployeeUsingNamedQuery(Integer id);
}
