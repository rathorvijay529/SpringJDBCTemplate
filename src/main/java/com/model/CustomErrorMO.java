package com.model;

import java.util.List;

public class CustomErrorMO {

	private final String TYPE = "CustomErrorEntity";
	private List<ErrorResponseMO> MultiErrorList;

	public CustomErrorMO() {
		super();
	}

	public CustomErrorMO(List<ErrorResponseMO> MultiErrorList) {
		super();
		this.MultiErrorList = MultiErrorList;
	}

	public List<ErrorResponseMO> getMultiErrorList() {
		return MultiErrorList;
	}

	public void setMultiErrorList(List<ErrorResponseMO> multiErrorList) {
		MultiErrorList = multiErrorList;
	}

	public String getTYPE() {
		return TYPE;
	}

}
