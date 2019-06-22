package com.properties;

public class Queries {
	
	public static final String INSERT_EMPLOYEES = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (?,?,?,?,?,?,?,?)";//wild card parameter
	public final static String queryForGettingAllEmployee = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public final static String queryForGettingEmployee = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=?";
	public final static String queryForUpdateEmployee = "Update  Employee set firstName=? , age=? , lastName=? , address=?  , bloodGroup=? , departmentName=? , employeeType=? where id=?";
	public final static String queryForDeleteEmployee = "Delete from Employee where id=?";

	public static final String INSERT_EMPLOYEESWithNamedParameter = "Insert into Employee (id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType) values (?,?,?,?,?,?,?,?)";//wild card parameter
	public final static String queryForGettingAllEmployeeWithNamedParameter = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee";
	public final static String queryForGettingEmployeeWithNamedParameter = "Select id,age,firstName,lastName,address,bloodGroup,departmentName,employeeType from Employee where id=?";
	public final static String queryForUpdateEmployeeWithNamedParameter = "Update  Employee set firstName=? , age=? , lastName=? , address=?  , bloodGroup=? , departmentName=? , employeeType=? where id=?";
	public final static String queryForDeleteEmployeeWithNamedParameter = "Delete from Employee where id=?";

	
}
