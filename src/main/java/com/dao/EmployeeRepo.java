package com.dao;

import java.util.List;

import com.entity.EmployeeEntity;
import com.model.Employee;

public interface EmployeeRepo {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees();
	
	public void delete(Integer id);
	
	public void save(EmployeeEntity emp);
	
	public String updateEmployee(EmployeeEntity emp);
	
	public Employee getEmployeeWithNamedParaMeter(Integer id);
	
	public void saveEmployeeUsingNamedParaMeter(EmployeeEntity emp);
	
	public void  deleteUsingNamedParameterQuery(Integer id);

}
