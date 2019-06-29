package com.service;

import java.util.List;

import com.entity.Employee;
import com.model.AddressMO;
import com.model.DepartmentMO;
import com.model.EmployeeMO;

public interface EmployeeService {
	public EmployeeMO processGetEmployee(Integer id);

	public List<EmployeeMO> processGetEmployees();

	public String processDelete(Integer id);

	public String processSave(EmployeeMO emp);

	public String processUpdateEmployee(EmployeeMO emp);

	public String processSaveUsingNamedParameter(EmployeeMO employeeEntity);

	public String processDeleteUsingNamedParameter(Integer id);

	public Employee processGetEmployeeUsingNamedQuery(Integer id);

	public List<Employee> processGetEmployeesUsingNamedQuery();

	public String processUpdateEmployeeUsingNamedQuery(EmployeeMO em);

	public String processSaveAddressDetails(AddressMO address);

	public String processSaveDepartmentDetails(DepartmentMO departmentEntity);

	public EmployeeMO getEmployeeDetailsByID(Integer id);
	
	public EmployeeMO processUpdateEmployeeForHibernate(EmployeeMO emp);
}
