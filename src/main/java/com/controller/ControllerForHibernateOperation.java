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
import com.model.EmployeeMO;
import com.model.ErrorResponseMO;
import com.model.SuccessResponseMO;
import com.service.EmployeeService;

@Controller
@RequestMapping("/hibernateMappingController")
public class ControllerForHibernateOperation {

	private static final Logger logger = Logger
			.getLogger(ControllerForHibernateOperation.class);
	@Autowired
	@Qualifier("hibernateService")
	private EmployeeService employeeService;

	@RequestMapping(value = "/getEmployees",method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		try {
			logger.debug("Invoking ofgetEmployees started");
			logger.debug("Controller::ControllerForHibernateOperation");
			logger.debug("Method::getEmployees");
			logger.debug("HTTP Method::GET");
			logger.debug("URL::/getEmployees");
			logger.debug("Arguments::" + null);
			return new ResponseEntity<Object>(
					employeeService.processGetEmployees(),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByID(@RequestParam("id") Integer id) {
	try {
			logger.debug("Invoking getEmployeeByID started");
			logger.debug("Controller::ControllerForHibernateOperation");
			logger.debug("Method::getEmployeeByID");
			logger.debug("HTTP Method::GET");
			logger.debug("URL::/getEmployeeByID");
			logger.debug("Arguments::" + id);
			return new ResponseEntity<Object>(
					employeeService.processGetEmployee(id),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeMO emp) {
		try {
			logger.debug("Invoking saveEmployee started");
			logger.debug("Controller::ControllerForHibernateOperation");
			logger.debug("Method::saveEmployee");
			logger.debug("HTTP Method::POST");
			logger.debug("URL::/saveEmployee");
			logger.debug("Arguments::" + emp);
			return new ResponseEntity<Object>(
					new SuccessResponseMO(
							HttpStatus.CREATED.value(), employeeService.processSave(emp)),
							HttpStatus.CREATED);


		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);  
 
		}
	}  
	 
	@RequestMapping(value = "/updateEmployeesData" , method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployeesData(@RequestBody EmployeeMO employeeEntity) {
		try {
			logger.debug("Invoking of updateEmployeesData started");
			logger.debug("Controller::ControllerForHibernateOperation");
			logger.debug("Method::updateEmployeesData");
			logger.debug("HTTP Method::PUT");
			logger.debug("URL::/updateEmployeesData");
			logger.debug("Arguments::" + employeeEntity);
			return new ResponseEntity<Object>(
					employeeService.processUpdateEmployee(employeeEntity),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	@RequestMapping(value = "/deleteEmployeesData" , method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployeeData(@RequestParam("id") Integer id) {
		try {
			logger.debug("Invoking of deleteEmployeeData started");
			logger.debug("Controller::ControllerForHibernateOperation");
			logger.debug("Method::deleteEmployeeData");
			logger.debug("HTTP Method::DELETE");
			logger.debug("URL::/updateEmployeesData");
			logger.debug("Arguments::" + id);
			return new ResponseEntity<Object>(
					employeeService.processDelete(id),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new  ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.NO_CONTENT.value(),
					HttpStatus.NO_CONTENT.getReasonPhrase()),
					HttpStatus.NO_CONTENT);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return  new ResponseEntity<>(new ErrorResponseMO(
					HttpStatus.NO_CONTENT.value(),
					HttpStatus.NO_CONTENT.getReasonPhrase()),
					HttpStatus.NO_CONTENT);
		}
	}
	
	
}
