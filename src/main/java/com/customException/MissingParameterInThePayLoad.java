package com.customException;

import com.entity.CustomErrorEntity;

public class MissingParameterInThePayLoad extends RuntimeException {
	private CustomErrorEntity customErrorEntity;

	public MissingParameterInThePayLoad() {
		super();
	}

	public MissingParameterInThePayLoad(CustomErrorEntity customErrorEntity) {
		super();
		this.customErrorEntity = customErrorEntity;
	}

	public CustomErrorEntity getCustomErrorEntity() {
		return customErrorEntity;
	}

	public void setCustomErrorEntity(CustomErrorEntity customErrorEntity) {
		this.customErrorEntity = customErrorEntity;
	}

}
