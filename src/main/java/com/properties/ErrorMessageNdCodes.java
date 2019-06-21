package com.properties;

public enum ErrorMessageNdCodes {
	DUPLICATE_EMPID(1000, "Duplicate empId"), 
	MISSING_FIRSTNAME(1001, "Missing Required::FirstName"),
	MISSING_LASTNAME(1002, "Missing Required::LastName"),
	MISSING_AGE(1003, "Missing Required::Age"),
	MISSING_BRANCHNAME(1004, "Missing Required::BranchName"),
	MISSING_EMPID(1005, "Missing Required::EmpId");
	

	private final int code;
	private final String description;

	private ErrorMessageNdCodes(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}
