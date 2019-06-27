package com.dao;

import java.util.List;

import com.entity.Address;
import com.entity.Department;
import com.entity.Employee;
import com.model.AddressEntity;
import com.model.DepartmentEntity;
import com.model.EmployeeEntity;

public interface EmployeeRepo {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees();
	
	public Integer delete(Integer id);
	
	public Integer save(EmployeeEntity emp);
	
	public Integer updateEmployee(EmployeeEntity emp);
	
	public Employee getEmployeeWithNamedParaMeter(Integer id);
	
	public Integer saveEmployeeUsingNamedParaMeter(EmployeeEntity emp);
	
	public Integer  deleteUsingNamedParameterQuery(Integer id);
	
	public List<Employee> getEmployeesWithNamedParaMete();
	
	public Integer updateEmployeeWithNamedParaMete(EmployeeEntity emp);
	
	public Integer saveAddressDetails(AddressEntity address);

	public Integer saveDepartmentDetails(DepartmentEntity departmentEntity);

	Address getAddressWithNamedParaMeter(Integer id);

	Department getDepartmentWithNamedParaMeter(Integer id);
	
	

}
