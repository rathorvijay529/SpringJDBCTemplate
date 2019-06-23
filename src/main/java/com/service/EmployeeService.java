package com.service;

import java.util.List;

import com.entity.EmployeeEntity;
import com.model.Employee;

public interface EmployeeService {
	public EmployeeEntity processGetEmployee(Integer id);

	public List<Employee> processGetEmployees();

	public String processDelete(Integer id);

	public String processSave(EmployeeEntity emp);

	public String processUpdateEmployee(EmployeeEntity emp);

	public String processSaveUsingNamedParameter(EmployeeEntity employeeEntity);

	public String processDeleteUsingNamedParameter(Integer id);
	
	public Employee processGetEmployeeUsingNamedQuery(Integer id);
	
	public List<Employee> processGetEmployeesUsingNamedQuery();
	
	public String processUpdateEmployeeUsingNamedQuery(EmployeeEntity em);
}
