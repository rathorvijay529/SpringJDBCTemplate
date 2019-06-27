package com.dao;

import java.util.List;

import com.entity.Address;
import com.entity.Department;
import com.entity.Employee;
import com.model.AddressEntity;
import com.model.DepartmentEntity;
import com.model.EmployeeEntity;

public class EmployeeRepoImplForHibernate extends AbstractDAO implements
		EmployeeRepo {

	public Employee getEmployee(Integer id) {

		return null;
	}

	public List<Employee> getEmployees() {

		return null;
	}

	public Integer delete(Integer id) {

		return null;
	}

	public Integer save(EmployeeEntity emp) {

		return null;
	}

	public Integer updateEmployee(EmployeeEntity emp) {

		return null;
	}

	public Employee getEmployeeWithNamedParaMeter(Integer id) {

		return null;
	}

	public Integer saveEmployeeUsingNamedParaMeter(EmployeeEntity emp) {

		return null;
	}

	public Integer deleteUsingNamedParameterQuery(Integer id) {

		return null;
	}


	public List<Employee> getEmployeesWithNamedParaMete() {

		return null;
	}

	@Override
	public Integer updateEmployeeWithNamedParaMete(EmployeeEntity emp) {

		return null;
	}

	@Override
	public Integer saveAddressDetails(AddressEntity address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveDepartmentDetails(DepartmentEntity departmentEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressWithNamedParaMeter(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentWithNamedParaMeter(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
