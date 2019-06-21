package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Employeerepo;
import com.entity.CustomErrorEntity;
import com.entity.EmployeeEntity;
import com.entity.ErrorEntity;
import com.exception.MissingFieldException;
import com.properties.ErrorMessageNdCodes;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private Employeerepo employeerepo;

	@Override
	public Boolean processingSaveEmployee(EmployeeEntity employeeEntity) {
		List<ErrorEntity> errorList = payLoadValidation(employeeEntity);
		if (errorList.size() == 0)
			return (employeerepo.saveWithNamedParameter(employeeEntity) == 1) ? true : false;
		else

			throw new MissingFieldException(new CustomErrorEntity(errorList));
	}

	@Override
	public EmployeeEntity getEmployee(Integer empId) {
		return employeerepo.getEmployee(empId);
	}

	@Override
	public List<EmployeeEntity> getEmployees() {
		return employeerepo.getListOfEmployee();
	}

	@Override
	public Boolean deleteEmployee(Integer empId) {
		return employeerepo.deleteEmployee(empId);
	}

	@Override
	public EmployeeEntity updateEmployee(Integer empId) {
		return null;
	}

	public List<ErrorEntity> payLoadValidation(EmployeeEntity employeeEntity) {
		List<ErrorEntity> errorMsgList = new ArrayList<ErrorEntity>();
		if (null == employeeEntity.getEmployeeId()) {
			errorMsgList.add(new ErrorEntity(ErrorMessageNdCodes.MISSING_EMPID.getDescription(),
					ErrorMessageNdCodes.MISSING_EMPID.getCode()));
		} /*
			 * else if (null !=
			 * employeerepo.getEmployee(employeeEntity.getEmployeeId())) {
			 * errorMsgList.add(new
			 * ErrorEntity(ErrorMessageNdCodes.DUPLICATE_EMPID.getDescription(),
			 * ErrorMessageNdCodes.DUPLICATE_EMPID.getCode())); }
			 */
		if (null == employeeEntity.getFname()) {
			errorMsgList.add(new ErrorEntity(ErrorMessageNdCodes.MISSING_FIRSTNAME.getDescription(),
					ErrorMessageNdCodes.MISSING_FIRSTNAME.getCode()));
		}
		if (null == employeeEntity.getLname()) {
			errorMsgList.add(new ErrorEntity(ErrorMessageNdCodes.MISSING_LASTNAME.getDescription(),
					ErrorMessageNdCodes.MISSING_LASTNAME.getCode()));
		}
		if (null == employeeEntity.getAge()) {
			errorMsgList.add(new ErrorEntity(ErrorMessageNdCodes.MISSING_AGE.getDescription(),
					ErrorMessageNdCodes.MISSING_AGE.getCode()));
		}
		if (null == employeeEntity.getBranchName()) {
			errorMsgList.add(new ErrorEntity(ErrorMessageNdCodes.MISSING_BRANCHNAME.getDescription(),
					ErrorMessageNdCodes.MISSING_BRANCHNAME.getCode()));
		}
		return errorMsgList;
	}
}
