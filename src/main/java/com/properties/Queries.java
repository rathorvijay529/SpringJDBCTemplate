package com.properties;

public class Queries {

	// 1.Wild card(jdbcTemplate)
	public static final String INSERT_EMPLOYEES = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (?,?,?,?,?,?,?,?)";
	public static final String QUERYFORALLEMPLOYEES = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERYFORGETTINGEMPLOYEE = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=?";
	public static final String QUERYFORUPDATEEMPLOYEE = "Update  Employee set firstName=? , age=? , lastName=? , address=?  , bloodGroup=? , departmentName=? , employeeType=? where id=?";
	public static final String QUERYFORDELETEEMPLOYEE = "Delete from Employee where id=?";
	// 2.Named parameter(NmaedJdbcTemplate)
	public static final String INSERT_EMPLOYEES_WIH_NAMED_PARAMETER = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (:id,:age,:firstName,:lastName,:address,:bloodGroup,:departmentName,:employeeType)";
	public static final String QUERY_FOR_ALL_EMPLOYEES_WITH_NAMED_PARAMETER = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERY_FOR_GETTING_EMPLOYEE_By_ID_WITH_NAMED_PARAMETER = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=:id";
	public static final String QUERY_FOR_UPDATE_EMPLOYEE_WITH_NAMED_PARAMETER = "Update  Employee set age=:age, firstName=:firstName , lastName=:lastName , address=:address  , bloodGroup=:bloodGroup , departmentName=:departmentName , employeeType=:employeeType where id=:id";
	public static final String QUERY_FOR_DELETE_EMPLOYEE_WITH_NAMED_PARAMETER = "Delete from Employee where id=:id";

	
	
}
