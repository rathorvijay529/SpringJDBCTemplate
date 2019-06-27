package com.model;

import java.util.List;

public class CustomErrorEntity {

	private final String TYPE = "CustomErrorEntity";
	private List<ErrorResponse> MultiErrorList;

	public CustomErrorEntity() {
		super();
	}

	public CustomErrorEntity(List<ErrorResponse> MultiErrorList) {
		super();
		this.MultiErrorList = MultiErrorList;
	}

	public List<ErrorResponse> getMultiErrorList() {
		return MultiErrorList;
	}

	public void setMultiErrorList(List<ErrorResponse> multiErrorList) {
		MultiErrorList = multiErrorList;
	}

	public String getTYPE() {
		return TYPE;
	}

}
