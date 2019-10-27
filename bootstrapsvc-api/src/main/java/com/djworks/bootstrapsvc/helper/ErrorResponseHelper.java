package com.djworks.bootstrapsvc.helper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.djworks.bootstrapsvc.api.datatype.Error;
import com.djworks.bootstrapsvc.api.models.response.ErrorResponse;
import com.djworks.bootstrapsvc.config.ErrorId;

@Component
public class ErrorResponseHelper {

	public Response makeErrorResponse(String errorMessage) {
		ErrorResponse errorResponse = new ErrorResponse(new Error(ErrorId.INTERNAL_SERVER_ERROR, errorMessage));
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
	}
}
