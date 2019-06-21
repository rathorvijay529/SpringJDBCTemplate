package com.properties;

public class Properties {

	public final static String queryForInsertEmployee = "Insert into Employee ( id, fname,lname,age,branchName) values (?,?,?,?,?)";
	public final static String queryForGettingAllEmployee = "Select id,fname,lname from Employee";
	public final static String queryForGettingEmployee = "Select id,fname,lname from Employee where id=? ";
	public final static String queryForUpdateEmployee = "Update  Employee set fname=? and lname=? where id=?";
	public final static String queryForDeleteEmployee = "Delete from Employee where id=?";

}
