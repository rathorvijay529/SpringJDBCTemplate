package com.entity;

public class ErrorEntity {

	private String errorMessage;
	private Integer ErrorCode;

	public ErrorEntity() {
		super();
	}

	public ErrorEntity(String errorMessage, Integer errorCode) {
		super();
		this.errorMessage = errorMessage;
		ErrorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}

}
