package com.dao;

import java.util.List;
import com.entity.EmployeeEntity;

public interface Employeerepo {

	public Integer save(EmployeeEntity employeeEntity);

	public List<EmployeeEntity> getListOfEmployee();

	public EmployeeEntity getEmployee(Integer empId);

	public Boolean deleteEmployee(Integer empId);

	public EmployeeEntity updateEmployee(Integer empId);

}
