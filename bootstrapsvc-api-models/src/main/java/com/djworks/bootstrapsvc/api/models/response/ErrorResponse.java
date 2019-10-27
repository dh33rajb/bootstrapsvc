package com.djworks.bootstrapsvc.api.models.response;

import com.djworks.bootstrapsvc.api.datatype.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

	private Error error;

	public ErrorResponse(Error error) {
		this.error = error;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
