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

import com.customException.MissingParameterInThePayLoad;
import com.entity.EmployeeEntity;
import com.entity.SuccessResponse;
import com.service.EmployeeService;

@Controller
@RequestMapping("/basicURL")
public class RestController {
	private static final Logger logger = Logger.getLogger(RestController.class);
	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee() {
		try {
			logger.info("Retriving the employee data started");
			logger.info("RestAPI::/getEmployees");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody :: " + "");
			return new ResponseEntity<Object>(empService.processGetEmployees(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<Object>(
				new SuccessResponse(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeById(@RequestParam("id") Integer id) {
		try {
			logger.info("Retriving the employee data started");
			logger.info("RestAPI::/getEmployeeById");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody :: " + "");
			return new ResponseEntity<Object>(empService.processGetEmployee(id), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<Object>(
				new SuccessResponse(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/saveEmpData", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEmpData(@RequestBody EmployeeEntity emp) {
		try {
			logger.info("Saving the Employee Data Started");
			logger.info("In the RestAPI::/saveEmpData");
			logger.info("HTTP Method Post");
			logger.info("Request Body ::" + emp);
			empService.processSave(emp);
			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.toString()), HttpStatus.CREATED);

		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<Object>(exception.getCustomErrorEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/updateEmpData", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmpData(@RequestBody EmployeeEntity emp) {
		try {
			logger.info("Updating the Employee Data Started");
			logger.info("In the RestAPI::/updateEmpData");
			logger.info("HTTP Method Post");
			logger.info("Request Body ::" + emp);
			empService.processUpdateEmployee(emp);
			return new ResponseEntity<Object>(
					new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.toString()), HttpStatus.OK);

		} catch (MissingParameterInThePayLoad exception) {
			logger.error(exception.getMessage());
			return new ResponseEntity<Object>(exception.getCustomErrorEntity(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") Integer id) {
		try {
			logger.info("Deleting the employee data started");
			logger.info("RestAPI::/deleteEmployee");
			logger.info("HTTP method :: Get");
			logger.info("RequestBody :: " + "id");
			empService.processDelete(id);
			return new ResponseEntity<Object>(new SuccessResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.toString()), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<Object>(
				new SuccessResponse(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString()),
				HttpStatus.NO_CONTENT);

	}
}
