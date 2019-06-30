package com.customException;

import com.model.CustomErrorMO;

public class MissingParameterInThePayLoad extends RuntimeException {
	private CustomErrorMO customErrorEntity;

	public MissingParameterInThePayLoad() {
		super();
	}

	public MissingParameterInThePayLoad(CustomErrorMO customErrorEntity) {
		super();
		this.customErrorEntity = customErrorEntity;
	}

	public CustomErrorMO getCustomErrorEntity() {
		return customErrorEntity;
	}

	public void setCustomErrorEntity(CustomErrorMO customErrorEntity) {
		this.customErrorEntity = customErrorEntity;
	}

}
