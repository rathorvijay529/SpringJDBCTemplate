package com.entity;

import java.util.List;

public class CustomErrorEntity {

	private final String TYPE = "CustomErrorEntity";
	private List<ErrorEntity> MultiErrorList;

	public CustomErrorEntity() {
		super();
	}

	public CustomErrorEntity(List<ErrorEntity> MultiErrorList) {
		super();
		this.MultiErrorList = MultiErrorList;
	}

	public List<ErrorEntity> getMultiErrorList() {
		return MultiErrorList;
	}

	public void setMultiErrorList(List<ErrorEntity> multiErrorList) {
		MultiErrorList = multiErrorList;
	}

	public String getTYPE() {
		return TYPE;
	}

}
