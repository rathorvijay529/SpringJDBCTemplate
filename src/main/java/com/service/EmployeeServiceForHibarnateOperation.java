package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customException.MissingParameterInThePayLoad;
import com.dao.AbstractDAO;
import com.dao.EmployeeRepoForHibernate;
import com.entity.Employee;
import com.model.AddressMO;
import com.model.CustomErrorMO;
import com.model.DepartmentMO;
import com.model.EmployeeMO;

@Service("hibernateService")
public class EmployeeServiceForHibarnateOperation extends AbstractDAO implements
		EmployeeService {

	@Autowired
	private EmployeeRepoForHibernate employeeRepoForHibernate;

	public EmployeeMO processGetEmployee(Integer id) {

		if (EmployeeServiceImplementation.payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(
					EmployeeServiceImplementation.payLoadValidationForID(id)));
		return EmployeeServiceImplementation
				.convertEmployee(employeeRepoForHibernate.getEmployee(id));
	}

	//vijeta--->create save ,test,validation ouput put in txt
	
	//update--->create update,Convertion ,test,validation ouput put in txt
	
	public List<EmployeeMO> processGetEmployees() {
		employeeRepoForHibernate.getEmployees();
		return null ;
	}

	public String processDelete(Integer id) {

		return null;
	}

	public String processSave(EmployeeMO emp) {

		return null;
	}

	public String processUpdateEmployee(EmployeeMO emp) {

		return null;
	}

	// non used
	public String processSaveUsingNamedParameter(EmployeeMO employeeEntity) {

		return null;
	}

	public String processDeleteUsingNamedParameter(Integer id) {

		return null;
	}

	public Employee processGetEmployeeUsingNamedQuery(Integer id) {

		return null;
	}

	public List<Employee> processGetEmployeesUsingNamedQuery() {

		return null;
	}

	public String processUpdateEmployeeUsingNamedQuery(EmployeeMO em) {

		return null;
	}

	@Override
	public String processSaveAddressDetails(AddressMO address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processSaveDepartmentDetails(DepartmentMO departmentEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeMO getEmployeeDetailsByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
