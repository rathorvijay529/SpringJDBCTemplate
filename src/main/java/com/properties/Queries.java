package com.properties;

public class Queries {

	// 1.Wild card(jdbcTemplate)
	public static final String INSERT_EMPLOYEES = "Insert into Employee (employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (?,?,?,?,?,?,?,?)";
	public static final String QUERYFORALLEMPLOYEES = "Select employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERYFORGETTINGEMPLOYEE = "Select employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where employeeId=?";
	public static final String QUERYFORUPDATEEMPLOYEE = "Update  Employee set firstName=? , age=? , lastName=? , address=?  , bloodGroup=? , departmentName=? , employeeType=? where employeeId=?";
	public static final String QUERYFORDELETEEMPLOYEE = "Delete from Employee where employeeId=?";
	
	public static final String INSERT_DEPARTMENT= "Insert into Department(employeeId,departmentID,departmentName,NumberOfEmployees) values(?,?,?,?)";
	public static final String INSERT_ADDRESS= "Insert  into Address(employeeId,addressID,fullAddress,city,pincode) values (?,?,?,?,?)";
	
	// 2.Named parameter(NmaedJdbcTemplate)
	public static final String INSERT_EMPLOYEES_WIH_NAMED_PARAMETER = "Insert into Employee (employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (:id,:age,:firstName,:lastName,:address,:bloodGroup,:departmentName,:employeeType)";
	public static final String QUERY_FOR_ALL_EMPLOYEES_WITH_NAMED_PARAMETER = "Select employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERY_FOR_GETTING_EMPLOYEE_By_ID_WITH_NAMED_PARAMETER = "Select employeeId,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where employeeId=:id";
	public static final String QUERY_FOR_UPDATE_EMPLOYEE_WITH_NAMED_PARAMETER = "Update  Employee set age=:age, firstName=:firstName , lastName=:lastName , address=:address  , bloodGroup=:bloodGroup , departmentName=:departmentName , employeeType=:employeeType where employeeId=:id";
	public static final String QUERY_FOR_DELETE_EMPLOYEE_WITH_NAMED_PARAMETER = "Delete from Employee where employeeId=:id";
	public static final String GET_DEPARTMENT_WIH_NAMED_PARAMETER = "Select employeeId,departmentID,departmentName,NumberOfEmployees from Department where employeeId=:id";
	public static final String GET_ADDRESS_WIH_NAMED_PARAMETER = "Select employeeId,addressID,fullAddress,city,pincode from Address where employeeId=:id";

	
	
}
