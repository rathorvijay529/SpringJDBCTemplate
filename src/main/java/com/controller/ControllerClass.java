package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customException.MissingParameterInThePayLoad;
import com.model.AddressMO;
import com.model.DepartmentMO;
import com.model.EmployeeMO;
import com.model.ErrorResponseMO;
import com.model.SuccessResponseMO;
import com.service.EmployeeService;

@Controller
@RequestMapping("/basicURL")
public class ControllerClass {

	private static final Logger logger = Logger
			.getLogger(ControllerForHibernateOperation.class);

	@Autowired
	@Qualifier("employeeServiceForJdbc")
	private EmployeeService empService;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee() {
		try {
			logger.info("Retriving the employee data started {}");
			logger.info("RestAPI::/getEmployees");
			logger.info("HTTP method :: Get {}");
			logger.info("RequestBody ::{}" + "");
			return new ResponseEntity<>(empService.processGetEmployees(),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeById(@RequestParam("id") Integer id) {
		try {
			logger.info("Retriving the employee data started");
			logger.info("RestAPI::/getEmployeeById");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody ::" + id);
			return new ResponseEntity<>(empService.processGetEmployee(id),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/saveEmpData", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmpData(@RequestBody EmployeeMO emp) {
		try {
			logger.info("Saving the Employee Data Started");
			logger.info("In the RestAPI::/saveEmpData");
			logger.info("HTTP Method ::Post");
			logger.info("Request Body ::{}" + emp);

			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.CREATED.value(), empService.processSave(emp)),
					HttpStatus.CREATED);

		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<>(exception.getCustomErrorEntity(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/updateEmpData", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmpData(@RequestBody EmployeeMO emp) {
		try {
			logger.info("Updating the Employee Data Started");
			logger.info("In the RestAPI::/updateEmpData");
			logger.info("HTTP Method Post");
			logger.info("Request Body ::" + emp);

			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.OK.value(),
					empService.processUpdateEmployee(emp)), HttpStatus.OK);

		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<>(exception.getCustomErrorEntity(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") Integer id) {
		try {
			logger.info("Deleting the employee data started");
			logger.info("RestAPI::/deleteEmployee");
			logger.info("HTTP method :: DELETE");
			logger.info("RequestBody ::{}" + id);
			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.OK.value(), empService.processDelete(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/saveEmpDataUsingNameQuery", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmpDataUsingNameQuery(
			@RequestBody EmployeeMO emp) {
		try {
			logger.info("Saving the Employee Data Started");
			logger.info("In the RestAPI::/saveEmpDataUsingNameQuery");
			logger.info("HTTP Method Post");
			logger.info("Request Body ::" + emp);

			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.CREATED.value(), empService.processSave(emp)),
					HttpStatus.CREATED);
		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<>(exception.getCustomErrorEntity(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteEmployeeUsingNamedQuery", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployeeUsingNamedQuery(
			@RequestParam("id") Integer id) {
		try {
			logger.info("Deleting the employee data started");
			logger.info("RestAPI::/deleteEmployeeUsingNamedQuery");
			logger.info("HTTP method :: DELETE");
			logger.info("RequestBody :: " + id);

			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.OK.value(),
					empService.processDeleteUsingNamedParameter(id)),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/getEmployeeByIDUsingNamedQuery", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByIDUsingNamedQuery(
			@RequestParam("id") Integer id) {
		try {
			logger.info("Retriving the employee data started");
			logger.info("RestAPI::/getEmployeeByIDUsingNamedQuery");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody :: " + id);
			return new ResponseEntity<>(
					empService.processGetEmployeeUsingNamedQuery(id),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/getEmployeesUsingNamedQuery", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeesUsingNamedQuery() {
		try {
			logger.info("Retriving the employee data started");
			logger.info("RestAPI::/getEmployeesByIDUsingNamedQuery");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody :: {}" + " ");
			return new ResponseEntity<>(
					empService.processGetEmployeesUsingNamedQuery(),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(
				new SuccessResponseMO(HttpStatus.NO_CONTENT.value(),
						HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/updateEmpDataUsingNamedQuery", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmpDataUsingNamedQuery(
			@RequestBody EmployeeMO emp) {
		try {
			logger.info("Updating the Employee Data Started");
			logger.info("In the RestAPI::/updateEmpDataUsingNamedQuery");
			logger.info("HTTP Method Post");
			logger.info("Request Body ::" + emp);

			return new ResponseEntity<>(new SuccessResponseMO(
					HttpStatus.OK.value(),
					empService.processUpdateEmployeeUsingNamedQuery(emp)),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<>(exception.getCustomErrorEntity(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/saveAddressDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAddressDetails(
			@RequestBody AddressMO address) {
		try {
			logger.info("Invoking saveAddressDetails started");
			logger.info("Method::saveAddressDetails");
			logger.info("HTTP Method::POST");
			logger.info("URL::/saveAddressDetails");
			logger.info("Arguments::" + address);
			return new ResponseEntity<Object>(new SuccessResponseMO(
					HttpStatus.CREATED.value(),
					empService.processSaveAddressDetails(address)),
					HttpStatus.CREATED);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/saveDepartmentDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> saveDepartmentDetails(
			@RequestBody DepartmentMO departmentEntity) {
		try {
			logger.info("Invoking saveDepartmentDetails started");
			logger.info("Method::saveDepartmentDetails");
			logger.info("HTTP Method::POST");
			logger.info("URL::/saveDepartmentDetails");
			logger.info("Arguments::" + departmentEntity);
			return new ResponseEntity<Object>(new SuccessResponseMO(
					HttpStatus.CREATED.value(),
					empService.processSaveDepartmentDetails(departmentEntity)),
					HttpStatus.CREATED);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/getAllDetailsByEmployeeId", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllDetailsByEmployeeId(
			@RequestParam("id") Integer id) {
		try {
			logger.info("Invoking getAllDetailsByEmployeeId started");
			logger.info("Method::getAllDetailsByEmployeeId");
			logger.info("HTTP Method::GET");
			logger.info("URL::/getAllDetailsByEmployeeId");
			logger.info("Arguments::" + id);
			return new ResponseEntity<Object>(
					empService.getEmployeeDetailsByID(id), HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
