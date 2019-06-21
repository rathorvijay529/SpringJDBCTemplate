package com.properties;

public class Properties {

	public final static String queryForInsertEmployee = "Insert into Employee ( id, fname,lname,age,branchName) values (?,?,?,?,?)";
	public final static String queryForGettingAllEmployee = "Select id,fname,lname from Employee";
	public final static String queryForGettingEmployee = "Select id,fname,lname from Employee where id=? ";
	public final static String queryForUpdateEmployee = "Update  Employee set fname=? and lname=? where id=?";
	public final static String queryForDeleteEmployee = "Delete from Employee where id=?";

	public final static String queryForInsertEmployeeWithNamedParaMeter = "Insert into Employee ( id, fname,lname,age,branchName) values (:id,:fname,:lname,:age,:branchName)";
	public final static String queryForGettingAllEmployeeWithNamedParaMeter = "Select id,fname,lname from Employee";
	public final static String queryForGettingEmployeeWithNamedParaMeter = "Select id,fname,lname from Employee where id=:id ";
	public final static String queryForUpdateEmployeeWithNamedParaMeter = "Update  Employee set fname=:fname and lname=:lname where id=:id";
	public final static String queryForDeleteEmployeeWithNamedParaMeter = "Delete from Employee where id=:id";

}
