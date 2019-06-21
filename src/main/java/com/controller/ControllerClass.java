package com.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.EmployeeEntity;
import com.entity.ErrorEntity;
import com.entity.SuccessEntity;
import com.exception.MissingFieldException;
import com.service.EmployeeService;

@Controller
public class ControllerClass {
	private final static Logger logger = Logger.getLogger(ControllerClass.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/saveEmployee", consumes = "Application/json", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		try {
			logger.info("**Saving the Employee data is started");
			if (employeeService.processingSaveEmployee(employeeEntity))
				return new ResponseEntity<Object>(
						new SuccessEntity("Data saved successfully", HttpStatus.CREATED.value()), HttpStatus.CREATED);

		} catch (MissingFieldException ex) {
			logger.error(ex.getLocalizedMessage());
			return new ResponseEntity<Object>(ex.getErrormsg(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception ex) {
			logger.error("Failed!!", ex);
		}
		return new ResponseEntity<Object>(new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, consumes = "Application/json")
	public ResponseEntity<Object> getEmployees() {
		try {
			logger.info("**Getting the Employee data is started");
			return new ResponseEntity<Object>(employeeService.getEmployees(), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
		}
		return new ResponseEntity<Object>(
				new SuccessEntity(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT.value()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, consumes = "Application/json")
	public ResponseEntity<Object> getEmployee(@RequestParam("id") Integer id) {
		try {
			logger.info("**Getting the Employee data is started");
			return new ResponseEntity<Object>(employeeService.getEmployee(id), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
		}
		return new ResponseEntity<Object>(
				new SuccessEntity(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT.value()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE, consumes = "Application/json")
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") Integer id) {
		/* try { */
		logger.info("**Deleting the Employee data is started");
		return new ResponseEntity<Object>(employeeService.deleteEmployee(id), HttpStatus.OK);
		/*
		 * } catch (Exception ex) { logger.error(ex.getLocalizedMessage()); }
		 */
		/*
		 * return new ResponseEntity<Object>( new
		 * SuccessEntity(HttpStatus.NO_CONTENT.getReasonPhrase(),
		 * HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT);
		 */
	}

}
