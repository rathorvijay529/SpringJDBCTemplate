package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.customException.MissingParameterInThePayLoad;
import com.dao.EmployeeRepo;
import com.entity.Address;
import com.entity.Department;
import com.entity.Employee;
import com.model.AddressMO;
import com.model.CustomErrorMO;
import com.model.DepartmentMO;
import com.model.EmployeeMO;
import com.model.ErrorResponseMO;
import com.properties.ErrorCodeMessages;

/**
 * @author vbopche
 *
 */
@Service("employeeServiceForJdbc")
public class EmployeeServiceImplementation implements EmployeeService {
	private static final Logger logger = Logger.getLogger(EmployeeServiceImplementation.class);
	@Autowired
	@Qualifier("employeeRepoForJDBC")
	private EmployeeRepo empRepo;

	public EmployeeMO processGetEmployee(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployee");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationForID(id)));
		return convertEmployeeEntityToModel(empRepo.getEmployee(id));
	}

	public Employee processGetEmployeeUsingNamedQuery(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployeeUsingNamedQuery");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationForID(id)));
		return empRepo.getEmployeeWithNamedParaMeter(id);
	}


	public List<EmployeeMO> processGetEmployees() {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployees");
		logger.info("Argument::" + "");
		return convertIntoEmployees(empRepo.getEmployees());
	}

	

	public String processDelete(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Deleting the Employee is processing, method name::processDelete");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationForID(id)));
		logger.info("Delete is completed");
		return (empRepo.delete(id) == 1) ? "Data Successfully deleted" : "Data does not deleted";

	}

	public String processSave(EmployeeMO employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Saving the Employee is processing method name::processSave");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponseMO> errlist = payLoadValidation(employeeEntity, false);
		if (errlist.size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(errlist));
		logger.info("Saving Layer Invoking is completed");
		return empRepo.save(employeeEntity) == 1 ? "Data saved successfully" : "Data does not saved successfully";
	}

	public String processSaveUsingNamedParameter(EmployeeMO employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Saving the Employee is processing method name::processSaveUsingNamedParameter");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponseMO> errlist = payLoadValidation(employeeEntity, false);
		if (errlist.size() != 0)

			throw new MissingParameterInThePayLoad(new CustomErrorMO(errlist));

		logger.info("Saving Layer Invoking is completed");
		return empRepo.saveEmployeeUsingNamedParaMeter(employeeEntity) == 1 ? "Data saved successfully"
				: "Data does not saved successfully";

	}

	public String processDeleteUsingNamedParameter(Integer id) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Deleting the Employee is processing, method name::processDeleteUsingNamedParameter");
		logger.info("Argument::" + "id");
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationForID(id)));
		logger.info("Delete is completed");
		return (empRepo.deleteUsingNamedParameterQuery(id) == 1) ? "Data Successfully deleted"
				: "Data does not deleted";

	}

	public String processUpdateEmployee(EmployeeMO employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Updating the Employee is processing method name::processUpdateEmployee");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponseMO> errlist = payLoadValidation(employeeEntity, false);
		if (errlist.size() == 0)
			empRepo.updateEmployee(employeeEntity);
		else
			throw new MissingParameterInThePayLoad(new CustomErrorMO(errlist));
		logger.info("Updating Layer Invoking is completed");
		return (empRepo.updateEmployee(employeeEntity) == 1) ? "Data  Updated Successfully" : "Data does not Updated";
	}

	public List<Employee> processGetEmployeesUsingNamedQuery() {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Retriving the Employee is processing method name::processGetEmployeesUsingNamedQuery");
		logger.info("Argument::" + "");
		return empRepo.getEmployeesWithNamedParaMete();
	}

	public String processUpdateEmployeeUsingNamedQuery(EmployeeMO employeeEntity) {
		logger.info("Service Layer Invoked::EmployeeServiceImplementation");
		logger.info("Updating the Employee is processing method name::processUpdateEmployeeUsingNamedQuery");
		logger.info("Argument::" + employeeEntity);
		List<ErrorResponseMO> errlist = payLoadValidation(employeeEntity, false);
		if (errlist.size() == 0)
			empRepo.updateEmployeeWithNamedParaMete(employeeEntity);
		else
			throw new MissingParameterInThePayLoad(new CustomErrorMO(errlist));
		logger.info("Updating Layer Invoking is completed");
		return (empRepo.updateEmployeeWithNamedParaMete(employeeEntity) == 1) ? "Data  Updated Successfully"
				: "Data does not Update";
	}

	public static List<ErrorResponseMO> payLoadValidationForID(Integer id) {
		List<ErrorResponseMO> errorList = new ArrayList<ErrorResponseMO>();
		if (null == id)
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_EMPID.getCode(),
					ErrorCodeMessages.MISSING_EMPID.getDescription()));

		return errorList;
	}

	@Override
	public String processSaveAddressDetails(AddressMO address) {
		logger.info("Service Layer Invoked::EmployeeService");
		logger.info("Saving the Employee is processing method name::processSaveAddressDetails");
		logger.info("Argument::" + address);
		if (payLoadValidationforAddress(address).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationforAddress(address)));
		logger.info("Saving Layer Invoking is completed");
		return empRepo.saveAddressDetails(address) == 1 ? "Data saved successfully"
				: "Data does not saved successfully";

	}

	@Override
	public String processSaveDepartmentDetails(DepartmentMO departmentEntity) {
		logger.info("Service Layer Invoked::EmployeeService");
		logger.info("Saving the Employee is processing method name::processSaveDepartmentDetails");
		logger.info("Argument::" + departmentEntity);
		if (payLoadValidationforDepartment(departmentEntity).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationforDepartment(departmentEntity)));
		logger.info("Saving Layer Invoking is completed");
		return empRepo.saveDepartmentDetails(departmentEntity) == 1 ? "Data saved successfully"
				: "Data does not saved successfully";
	}

	@Override
	public EmployeeMO getEmployeeDetailsByID(Integer id) {
		logger.info("Service Layer Invoked::EmployeeService");
		logger.info("Retriving the Employee is processing method name::getEmployee");
		logger.info("Argument::" + id);
		if (payLoadValidationForID(id).size() != 0)
			throw new MissingParameterInThePayLoad(new CustomErrorMO(payLoadValidationForID(id)));
		return convertIntoEmployeeDetails(empRepo.getEmployee(id), empRepo.getAddressWithNamedParaMeter(id),
				empRepo.getDepartmentWithNamedParaMeter(id));

	}

	public static EmployeeMO convertEmployeeEntityToModel(Employee employee) {
		EmployeeMO employeeMo = new EmployeeMO();
		employeeMo.setId(employee.getId());
		employeeMo.setFirstName(employee.getFirstName());
		employeeMo.setLastName(employee.getLastName());
		employeeMo.setAge(employee.getAge());
		employeeMo.setBloodGroup(employee.getBloodGroup());
		employeeMo.setDepartmentName(employee.getDepartmentName());
		employeeMo.setEmployeeType(employee.getEmployeeType());
		employeeMo.setAddress(employee.getAddress());
		return employeeMo;
	}
	
	public static Employee convertEmployeeModelToEntity(EmployeeMO employeeMO) {
		Employee employee = new Employee();
		//employee.setId(employeeMO.getId());
		employee.setFirstName(employeeMO.getFirstName());
		employee.setLastName(employeeMO.getLastName());
		employee.setAge(employeeMO.getAge());
		employee.setBloodGroup(employeeMO.getBloodGroup());
		employee.setDepartmentName(employeeMO.getDepartmentName());
		employee.setEmployeeType(employeeMO.getEmployeeType());
		employee.setAddress(employeeMO.getAddress());
		return employee;
	}

	public static List<ErrorResponseMO> payLoadValidationforAddress(AddressMO addressEntity) {
		List<ErrorResponseMO> errorList = new ArrayList<ErrorResponseMO>();
		if (null == addressEntity.getEmployeeId())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_EMPID.getCode(),
					ErrorCodeMessages.MISSING_EMPID.getDescription()));

		if (null == addressEntity.getAddressId())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_ADDRESSID.getCode(),
					ErrorCodeMessages.MISSING_ADDRESSID.getDescription()));

		if (null == addressEntity.getCity())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_CITY.getCode(),
					ErrorCodeMessages.MISSING_CITY.getDescription()));

		if (null == addressEntity.getFullAddress())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_FULLADDRESS.getCode(),
					ErrorCodeMessages.MISSING_FULLADDRESS.getDescription()));

		if (null == addressEntity.getPincode())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_PINCODE.getCode(),
					ErrorCodeMessages.MISSING_PINCODE.getDescription()));
		return errorList;
	}

	public static List<ErrorResponseMO> payLoadValidationforDepartment(DepartmentMO departmentEntity) {
		List<ErrorResponseMO> errorList = new ArrayList<ErrorResponseMO>();
		if (null == departmentEntity.getEmployeeId())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_EMPID.getCode(),
					ErrorCodeMessages.MISSING_EMPID.getDescription()));

		if (null == departmentEntity.getDepartmentId())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_DEPARTMENTID.getCode(),
					ErrorCodeMessages.MISSING_DEPARTMENTID.getDescription()));

		if (null == departmentEntity.getDepartmentName())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_DEPARTMENTNAME.getCode(),
					ErrorCodeMessages.MISSING_DEPARTMENTNAME.getDescription()));

		if (null == departmentEntity.getNumberOfEmployees())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_NUMBEROFEMPLOYEES.getCode(),
					ErrorCodeMessages.MISSING_NUMBEROFEMPLOYEES.getDescription()));

		return errorList;
	}

	public static EmployeeMO convertIntoEmployeeDetails(Employee employee, Address address, Department department) {
		EmployeeMO employeeEntity = null;
		AddressMO addressEntity = null;
		DepartmentMO departmentEntity = null;
		if (employee != null) {
			employeeEntity = new EmployeeMO();
			employeeEntity.setId(employee.getId());
			employeeEntity.setFirstName(employee.getFirstName());
			employeeEntity.setLastName(employee.getLastName());
			employeeEntity.setAge(employee.getAge());
			employeeEntity.setBloodGroup(employee.getBloodGroup());
			employeeEntity.setDepartmentName(employee.getDepartmentName());
			employeeEntity.setEmployeeType(employee.getEmployeeType());
			employeeEntity.setAddress(employee.getAddress());

		}
		if (address != null) {
			addressEntity = new AddressMO();
			addressEntity.setAddressId(address.getAddressId());
			addressEntity.setFullAddress(address.getFullAddress());
			addressEntity.setCity(address.getCity());
			addressEntity.setPincode(address.getPincode());
		}
		if (department != null) {
			departmentEntity = new DepartmentMO();
			departmentEntity.setDepartmentId(department.getDepartmentId());
			departmentEntity.setDepartmentName(department.getDepartmentName());
			departmentEntity.setNumberOfEmployees(department.getNumberOfEmployees());
			employeeEntity.setAddressDetails(addressEntity);
			employeeEntity.setDepartmentDetails(departmentEntity);
		}
		return employeeEntity;

	}

	public static List<ErrorResponseMO> payLoadValidation(
			EmployeeMO employeeEntity, boolean hibernateFlag) {

		List<ErrorResponseMO> errorList = new ArrayList<ErrorResponseMO>();
		
		if (null == employeeEntity.getId()&&!hibernateFlag)
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_EMPID
					.getCode(), ErrorCodeMessages.MISSING_EMPID
					.getDescription()));
		if (null == employeeEntity.getAge())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_AGE.getCode(),
					ErrorCodeMessages.MISSING_AGE.getDescription()));

		if (null == employeeEntity.getAddress())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_ADDRESS.getCode(),
					ErrorCodeMessages.MISSING_ADDRESS.getDescription()));

		if (null == employeeEntity.getBloodGroup())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_BLOODGROUP.getCode(),
					ErrorCodeMessages.MISSING_BLOODGROUP.getDescription()));

		if (null == employeeEntity.getDepartmentName())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_DEPARTMENTNAME.getCode(),
					ErrorCodeMessages.MISSING_DEPARTMENTNAME.getDescription()));

		if (null == employeeEntity.getEmployeeType())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_EMPLOYEETYPE.getCode(),
					ErrorCodeMessages.MISSING_EMPLOYEETYPE.getDescription()));

		if (null == employeeEntity.getFirstName())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_FIRSTNAME.getCode(),
					ErrorCodeMessages.MISSING_FIRSTNAME.getDescription()));

		if (null == employeeEntity.getLastName())
			errorList.add(new ErrorResponseMO(ErrorCodeMessages.MISSING_LASTNAME.getCode(),
					ErrorCodeMessages.MISSING_LASTNAME.getDescription()));

		return errorList;
	}
	
	public static List<EmployeeMO> convertIntoEmployees(List<Employee> employeeList) {
		List<EmployeeMO> employeeMO = null;
		if (employeeList != null) {
			employeeMO = new ArrayList<>();
			for (Employee employee : employeeList) {
				EmployeeMO empMo = new EmployeeMO();
				empMo.setId(employee.getId());
				empMo.setFirstName(employee.getFirstName());
				empMo.setLastName(employee.getLastName());
				empMo.setAge(employee.getAge());
				empMo.setBloodGroup(employee.getBloodGroup());
				empMo.setDepartmentName(employee.getDepartmentName());
				empMo.setEmployeeType(employee.getEmployeeType());
				empMo.setAddress(employee.getAddress());
				employeeMO.add(empMo);
			}

		}
		return employeeMO;

	}

	@Override
	public EmployeeMO processUpdateEmployeeForHibernate(EmployeeMO emp) {
		return null;
	}

	@Override
	public EmployeeMO processSaveForHibernate(EmployeeMO emp) {
		return null;
	}

}
