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
import com.model.ErrorResponseMO;

@Service("hibernateService")
public class EmployeeServiceForHibarnateOperation extends AbstractDAO implements EmployeeService {

	@Autowired
	private EmployeeRepoForHibernate employeeRepoForHibernate;

	public EmployeeMO processGetEmployee(Integer id) {

		if (EmployeeServiceImplementation.payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(
					new CustomErrorMO(EmployeeServiceImplementation.payLoadValidationForID(id)));
		return EmployeeServiceImplementation.convertEmployee(employeeRepoForHibernate.getEmployee(id));
	}


	public List<EmployeeMO> processGetEmployees() {
		return EmployeeServiceImplementation.convertIntoEmployees(employeeRepoForHibernate.getEmployees());
	}

	public String processDelete(Integer id) {

		return null;
	}

	public String processSave(EmployeeMO emp) {

		return null;
	}

	public EmployeeMO processUpdateEmployeeForHibernate(EmployeeMO emp) {

		List<ErrorResponseMO> errlist = EmployeeServiceImplementation.payLoadValidation(emp);
		if (errlist.size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(errlist));
		return EmployeeServiceImplementation.convertEmployee(employeeRepoForHibernate.updateEmployeeForHibernate(emp));
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

	@Override
	public String processUpdateEmployee(EmployeeMO emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
