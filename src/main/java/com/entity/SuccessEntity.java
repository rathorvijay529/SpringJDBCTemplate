package com.entity;

public class SuccessEntity {

	private String successMsg;
	private Integer successCode;

	public SuccessEntity() {
		super();
	}

	public SuccessEntity(String successMsg, Integer successCode) {
		super();
		this.successMsg = successMsg;
		this.successCode = successCode;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public Integer getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(Integer successCode) {
		this.successCode = successCode;
	}

}
