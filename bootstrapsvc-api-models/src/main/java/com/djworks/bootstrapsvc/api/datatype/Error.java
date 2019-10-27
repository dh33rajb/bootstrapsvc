package com.djworks.bootstrapsvc.api.datatype;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {

	private int errorId;

	private String errorMessage;

	public Error(int errorId, String errorMessage) {
		this.errorId = errorId;
		this.errorMessage = errorMessage;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
