package com.dao;

import java.util.List;

import com.entity.Address;
import com.entity.Department;
import com.entity.Employee;
import com.model.AddressMO;
import com.model.DepartmentMO;
import com.model.EmployeeMO;

public interface EmployeeRepo {
	public Employee getEmployee(Integer id);

	public List<Employee> getEmployees();
	
	public Integer delete(Integer id);
	
	public Integer save(EmployeeMO emp);
	
	public Integer updateEmployee(EmployeeMO emp);
	
	public Employee getEmployeeWithNamedParaMeter(Integer id);
	
	public Integer saveEmployeeUsingNamedParaMeter(EmployeeMO emp);
	
	public Integer  deleteUsingNamedParameterQuery(Integer id);
	
	public List<Employee> getEmployeesWithNamedParaMete();
	
	public Integer updateEmployeeWithNamedParaMete(EmployeeMO emp);
	
	public Integer saveAddressDetails(AddressMO address);

	public Integer saveDepartmentDetails(DepartmentMO departmentEntity);

	Address getAddressWithNamedParaMeter(Integer id);

	Department getDepartmentWithNamedParaMeter(Integer id);
	
	
	
	

}
