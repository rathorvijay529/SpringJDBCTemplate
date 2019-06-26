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
public class ControllerClass {

    private static final Logger LOGGER = Logger
            .getLogger(ControllerClass.class);
    @Autowired
    private EmployeeService empService;

    @RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployee() {
        try {
            LOGGER.info("Retriving the employee data started {}");
            LOGGER.info("RestAPI::/getEmployees");
            LOGGER.info("HTTP method :: Get {}");
            LOGGER.info("RequestBody ::{}" + "");
            return new ResponseEntity<>(empService.processGetEmployees(),
                    HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeById(@RequestParam("id") Integer id) {
        try {
            LOGGER.info("Retriving the employee data started");
            LOGGER.info("RestAPI::/getEmployeeById");
            LOGGER.info("HTTP method :: Get");
            LOGGER.info("RequestBody ::{}" + id);
            return new ResponseEntity<>(
                    empService.processGetEmployee(id), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/saveEmpData", method = RequestMethod.POST)
    public ResponseEntity<Object> saveEmpData(@RequestBody EmployeeEntity emp) {
        try {
            LOGGER.info("Saving the Employee Data Started");
            LOGGER.info("In the RestAPI::/saveEmpData");
            LOGGER.info("HTTP Method ::Post");
            LOGGER.info("Request Body ::{}" + emp);

            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.CREATED.value(), empService.processSave(emp)),
                    HttpStatus.CREATED);

        } catch (MissingParameterInThePayLoad exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>(exception.getCustomErrorEntity(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateEmpData", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmpData(@RequestBody EmployeeEntity emp) {
        try {
            LOGGER.info("Updating the Employee Data Started");
            LOGGER.info("In the RestAPI::/updateEmpData");
            LOGGER.info("HTTP Method Post");
            LOGGER.info("Request Body ::" + emp);

            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.OK.value(),
                    empService.processUpdateEmployee(emp)), HttpStatus.OK);

        } catch (MissingParameterInThePayLoad exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>(exception.getCustomErrorEntity(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@RequestParam("id") Integer id) {
        try {
            LOGGER.info("Deleting the employee data started");
            LOGGER.info("RestAPI::/deleteEmployee");
            LOGGER.info("HTTP method :: DELETE");
            LOGGER.info("RequestBody ::{}" + id);
            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.OK.value(), empService.processDelete(id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/saveEmpDataUsingNameQuery", method = RequestMethod.POST)
    public ResponseEntity<Object> saveEmpDataUsingNameQuery(
            @RequestBody EmployeeEntity emp) {
        try {
            LOGGER.info("Saving the Employee Data Started");
            LOGGER.info("In the RestAPI::/saveEmpDataUsingNameQuery");
            LOGGER.info("HTTP Method Post");
            LOGGER.info("Request Body ::" + emp);

            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.CREATED.value(), empService.processSave(emp)),
                    HttpStatus.CREATED);
        } catch (MissingParameterInThePayLoad exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>(exception.getCustomErrorEntity(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteEmployeeUsingNamedQuery", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployeeUsingNamedQuery(
            @RequestParam("id") Integer id) {
        try {
            LOGGER.info("Deleting the employee data started");
            LOGGER.info("RestAPI::/deleteEmployeeUsingNamedQuery");
            LOGGER.info("HTTP method :: DELETE");
            LOGGER.info("RequestBody :: " + id);

            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.OK.value(),
                    empService.processDeleteUsingNamedParameter(id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/getEmployeeByIDUsingNamedQuery", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeeByIDUsingNamedQuery(
            @RequestParam("id") Integer id) {
        try {
            LOGGER.info("Retriving the employee data started");
            LOGGER.info("RestAPI::/getEmployeeByIDUsingNamedQuery");
            LOGGER.info("HTTP method :: Get");
            LOGGER.info("RequestBody :: " + id);
            return new ResponseEntity<>(
                    empService.processGetEmployeeUsingNamedQuery(id),
                    HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/getEmployeesUsingNamedQuery", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployeesUsingNamedQuery() {
        try {
            LOGGER.info("Retriving the employee data started");
            LOGGER.info("RestAPI::/getEmployeesByIDUsingNamedQuery");
            LOGGER.info("HTTP method :: Get");
            LOGGER.info("RequestBody :: {}" + " ");
            return new ResponseEntity<>(empService.processGetEmployeesUsingNamedQuery(),
                    HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.toString()),
                HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/updateEmpDataUsingNamedQuery", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmpDataUsingNamedQuery(@RequestBody EmployeeEntity emp) {
        try {
            LOGGER.info("Updating the Employee Data Started");
            LOGGER.info("In the RestAPI::/updateEmpDataUsingNamedQuery");
            LOGGER.info("HTTP Method Post");
            LOGGER.info("Request Body ::" + emp);

            return new ResponseEntity<>(new SuccessResponse(
                    HttpStatus.OK.value(),
                    empService.processUpdateEmployeeUsingNamedQuery(emp)), HttpStatus.OK);

        } catch (MissingParameterInThePayLoad exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>(exception.getCustomErrorEntity(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
