package com.dao;

import java.util.List;

import com.entity.EmployeeEntity;
import com.model.Employee;

public interface EmployeeRepo {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees();
	
	public Integer delete(Integer id);
	
	public Integer save(EmployeeEntity emp);
	
	public Integer updateEmployee(EmployeeEntity emp);
	
	public Employee getEmployeeWithNamedParaMeter(Integer id);
	
	public Integer saveEmployeeUsingNamedParaMeter(EmployeeEntity emp);
	
	public Integer  deleteUsingNamedParameterQuery(Integer id);

}
