package com.properties;
/**
 * @author rizwan
 *
 */
public enum ErrorCodeMessages {
	DUPLICATE_EMPID(1000, "Duplicate Id"),
	MISSING_EMPID(1001, "Missing Required::Id"),
	MISSING_AGE(1002, "Missing Required::Age"),
	MISSING_FIRSTNAME(1003, "Missing Required::FirstName"),
	MISSING_LASTNAME(1004, "Missing Required::LastName"),
	MISSING_ADDRESS(1005, "Missing Required::address"),
	MISSING_BLOODGROUP(1006, "Missing Required::bloodGroup"),
	MISSING_DEPARTMENTNAME(1007, "Missing Required::departmentName"),
	MISSING_EMPLOYEETYPE(1008, "Missing Required::employeeType"),
	DUPLICATE_ADDRESSID(1009, "Duplicate::addressId"),
	MISSING_ADDRESSID(1010, "Missing Requir::addressId"),
	MISSING_FULLADDRESS(1011, "Missing Requir::fulladdress"),
	MISSING_CITY(1012, "Missing Requir::city"),
	MISSING_PINCODE(1013, "Missing Requir::pinCode"),
	MISSING_DEPARTMENTID(1014, "Missing Requir::departmentID"),
	DUPLICATE_DEPARTMENTID(1015, "Duplicate::departmentID"),
	MISSING_NUMBEROFEMPLOYEES(1016, "Missing Requir::NumberOfEmployees");
	
	private final Integer code;
	private final String description;
	
	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	private ErrorCodeMessages(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	


}
