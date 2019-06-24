package com.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customException.MissingParameterInThePayLoad;
import com.entity.ErrorResponse;
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
	
	//delete, update---vijeta
	//getEmployee, save-- rizwan
}
