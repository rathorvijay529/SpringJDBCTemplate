package com.service;

import java.util.List;

import com.entity.EmployeeEntity;

public interface EmployeeService {

	public Boolean processingSaveEmployee(EmployeeEntity employeeEntity);

	public EmployeeEntity getEmployee(Integer empId);

	public List<EmployeeEntity> getEmployees();

	public Boolean deleteEmployee(Integer empId);

	public EmployeeEntity updateEmployee(Integer empId);

}
