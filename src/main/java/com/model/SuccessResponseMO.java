package com.model;

public class SuccessResponseMO {

	private int successCode;
	private String successMessage;

	public SuccessResponseMO(int successCode, String successMessage) {
		super();
		this.successCode = successCode;
		this.successMessage = successMessage;
	}

	public int getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(int successCode) {
		this.successCode = successCode;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
