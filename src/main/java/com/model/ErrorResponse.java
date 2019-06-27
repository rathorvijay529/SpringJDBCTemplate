package com.model;

public class ErrorResponse {
	private Integer errorCode;
	private String errorMSG;

	public ErrorResponse(Integer errorCode, String errorMSG) {
		super();
		this.errorCode = errorCode;
		this.errorMSG = errorMSG;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMSG() {
		return errorMSG;
	}

	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", errorMSG=" + errorMSG + "]";
	}

}
