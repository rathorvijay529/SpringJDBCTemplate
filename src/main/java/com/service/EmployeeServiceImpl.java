package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controller.RestController;
import com.customException.MissingParameterInThePayLoad;
import com.dao.EmployeeRepo;
import com.entity.CustomErrorEntity;
import com.entity.EmployeeEntity;
import com.entity.ErrorResponse;
import com.model.Employee;
import com.properties.ErrorCodeMessages;

/**
 * @author vbopche
 *
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	private static final Logger logger = Logger.getLogger(EmployeeServiceImplementation.class);
	@Autowired
	private EmployeeRepo empRepo;

	public Employee processGetEmployee(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployee");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorEntity(payLoadValidationForID(id)));
		return empRepo.getEmployee(id);
	}

	public List<Employee> processGetEmployees() {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployees");
		logger.info("Argument::" + "");
		return empRepo.getEmployees();
	}

	public void processDelete(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Deleting the Employee is processing, method name::processDelete");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorEntity(payLoadValidationForID(id)));
		empRepo.delete(id);
		logger.info("Delete is completed");
	}

	public void processSave(EmployeeEntity employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Saving the Employee is processing method name::processSave");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponse> errlist = payLoadValidation(employeeEntity);
		if (errlist.size() == 0)
			empRepo.save(employeeEntity);
		else
			throw new MissingParameterInThePayLoad(new CustomErrorEntity(errlist));

		logger.info("Saving Layer Invoking is completed");
	}

	public String processUpdateEmployee(EmployeeEntity employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Updating the Employee is processing method name::processUpdateEmployee");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponse> errlist = payLoadValidation(employeeEntity);
		if (errlist.size() == 0)
			empRepo.updateEmployee(employeeEntity);
		else
			throw new MissingParameterInThePayLoad(new CustomErrorEntity(errlist));

		logger.info("Updating Layer Invoking is completed");
		return empRepo.updateEmployee(employeeEntity);
	}

	private List<ErrorResponse> payLoadValidation(EmployeeEntity employeeEntity) {

		List<ErrorResponse> errorList = new ArrayList<ErrorResponse>();
		if (null == employeeEntity.getId())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_EMPID.getCode(),
					ErrorCodeMessages.MISSING_EMPID.getDescription()));

		if (null == employeeEntity.getAge())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_AGE.getCode(),
					ErrorCodeMessages.MISSING_AGE.getDescription()));

		if (null == employeeEntity.getAddress())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_ADDRESS.getCode(),
					ErrorCodeMessages.MISSING_ADDRESS.getDescription()));

		if (null == employeeEntity.getBloodGroup())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_BLOODGROUP.getCode(),
					ErrorCodeMessages.MISSING_BLOODGROUP.getDescription()));

		if (null == employeeEntity.getDepartmentName())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_DEPARTMENTNAME.getCode(),
					ErrorCodeMessages.MISSING_DEPARTMENTNAME.getDescription()));

		if (null == employeeEntity.getEmployeeType())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_EMPLOYEETYPE.getCode(),
					ErrorCodeMessages.MISSING_EMPLOYEETYPE.getDescription()));

		if (null == employeeEntity.getFirstName())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_FIRSTNAME.getCode(),
					ErrorCodeMessages.MISSING_FIRSTNAME.getDescription()));

		if (null == employeeEntity.getLastName())
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_LASTNAME.getCode(),
					ErrorCodeMessages.MISSING_LASTNAME.getDescription()));

		return errorList;
	}

	private List<ErrorResponse> payLoadValidationForID(Integer id) {

		List<ErrorResponse> errorList = new ArrayList<ErrorResponse>();
		if (null == id)
			errorList.add(new ErrorResponse(ErrorCodeMessages.MISSING_EMPID.getCode(),
					ErrorCodeMessages.MISSING_EMPID.getDescription()));

		return errorList;
	}

}
