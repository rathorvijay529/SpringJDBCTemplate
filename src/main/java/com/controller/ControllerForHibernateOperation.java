package com.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customException.MissingParameterInThePayLoad;
import com.entity.EmployeeEntity;
import com.entity.ErrorResponse;
import com.entity.SuccessResponse;
import com.service.EmployeeServiceForHibarnateOperation;

@Controller
@RequestMapping("/hibernateMappingController")
public class ControllerForHibernateOperation {

	private static final Logger logger = Logger
			.getLogger(ControllerForHibernateOperation.class);
	private EmployeeServiceForHibarnateOperation employeeServiceForHibarnateOperation;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		try {
			logger.info("Invoking ofgetEmployees started");
			logger.info("Controller::ControllerForHibernateOperation");
			logger.info("Method::getEmployees");
			logger.info("HTTP Method::GET");
			logger.info("URL::/getEmployees");
			logger.info("Arguments::" + null);
			return new ResponseEntity<Object>(
					employeeServiceForHibarnateOperation.processGetEmployees(),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByID(@RequestParam("id") Integer id) {
		try {
			logger.info("Invoking getEmployeeByID started");
			logger.info("Controller::ControllerForHibernateOperation");
			logger.info("Method::getEmployeeByID");
			logger.info("HTTP Method::GET");
			logger.info("URL::/getEmployeeByID");
			logger.info("Arguments::" + id);
			return new ResponseEntity<Object>(
					employeeServiceForHibarnateOperation.processGetEmployee(id),
					HttpStatus.OK);

		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeEntity emp) {
		try {
			logger.info("Invoking saveEmployee started");
			logger.info("Controller::ControllerForHibernateOperation");
			logger.info("Method::saveEmployee");
			logger.info("HTTP Method::POST");
			logger.info("URL::/saveEmployee");
			logger.info("Arguments::" + emp);
			return new ResponseEntity<Object>(
					new SuccessResponse(
							HttpStatus.CREATED.value(), employeeServiceForHibarnateOperation.processSave(emp)),
							HttpStatus.CREATED);


		} catch (MissingParameterInThePayLoad missingParameterInThePayLoad) {
			logger.error(missingParameterInThePayLoad);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (RuntimeException exception) {
			logger.error(exception);
			return new ResponseEntity<>(new ErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.toString()),
					HttpStatus.INTERNAL_SERVER_ERROR); 

		}
	}
	
	
	//delete, update---vijeta
	//getEmployee, save-- rizwan
}
