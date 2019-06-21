package com.exception;

import com.entity.CustomErrorEntity;

public class MissingFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private CustomErrorEntity errormsg;

	public MissingFieldException(CustomErrorEntity errormsg) {
		super();
		this.errormsg = errormsg;
	}

	public CustomErrorEntity getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(CustomErrorEntity errormsg) {
		this.errormsg = errormsg;
	}

}
