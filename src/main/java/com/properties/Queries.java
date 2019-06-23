package com.properties;

public class Queries {

	// 1.Wild card(jdbcTemplate)
	public static final String INSERT_EMPLOYEES = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (?,?,?,?,?,?,?,?)";
	public static final String QUERYFORALLEMPLOYEES = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERYFORGETTINGEMPLOYEE = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=?";
	public static final String QUERYFORUPDATEEMPLOYEE = "Update  Employee set firstName=? , age=? , lastName=? , address=?  , bloodGroup=? , departmentName=? , employeeType=? where id=?";
	public static final String QUERYFORDELETEEMPLOYEE = "Delete from Employee where id=?";
	// 2.Named parameter(NmaedJdbcTemplate)
	public static final String INSERT_EMPLOYEESWIHNAMEDPARAMETER = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (:id,:age,:firstName,:lastName,:address,:bloodGroup,:departmentName,:employeeType)";
	public static final String QUERYFORALLEMPLOYEESWITHNAMEDPARAMETER = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public static final String QUERYFORGETTINGEMPLOYEEWITHNAMEDPARAMETER = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=:id";
	public static final String QUERYFORDELETEEMPLOYEEWITHNAMEDPARAMETER = "Update  Employee set firstName=:firstName , age=:age , lastName=:lastName , address=:address  , bloodGroup=:bloodGroup , departmentName=:departmentName , employeeType=:employeeType where id=:id";
	public static final String INSERT_EMPLOYEESWIHNAMEDPARAMETERWITHNAMEDPARAMETER = "Delete from Employee where id=:id";

	
	
}
