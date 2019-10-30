package com.djworks.bootstrapsvc.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.djworks.bootstrapsvc.api.models.request.CustomerRequest;
import com.djworks.bootstrapsvc.api.models.response.CustomerResponse;
import com.djworks.bootstrapsvc.api.models.response.CustomersResponse;
import com.djworks.bootstrapsvc.delegator.BootstrapDelegator;
import com.djworks.bootstrapsvc.delegator.BootstrapDelegatorException;
import com.djworks.bootstrapsvc.helper.ErrorResponseHelper;

@Controller
@Path("/")
public class BootstrapResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(BootstrapResource.class);

	@Autowired
	private BootstrapDelegator bootstrapDelegator;

	@Autowired
	private ErrorResponseHelper errorResponseHelper;

	/**
	 * Hello API to check liveness.
	 */
	@GET
	@Path("/hello")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response hello() {
		return Response.ok("Hello from bootstrap service!").build();
	}

	@GET
	@Path("/users")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsers() {
		return Response.status(Status.OK).entity(this.bootstrapDelegator.getUsers()).build();
	}

	/**
	 * Get customers API.
	 */
	@GET
	@Path("/customers")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCustomers() {
		CustomersResponse customersResponse = null;
		try {
			customersResponse = this.bootstrapDelegator.getCustomers();
		} catch (BootstrapDelegatorException e) {
			LOGGER.error(e.getMessage(), e);
			return errorResponseHelper.makeErrorResponse(e.getMessage());
		} catch (Exception e) {
			String errorMessage = "Internal server error while fetching data.";
			LOGGER.error(errorMessage, e);
			return errorResponseHelper.makeErrorResponse(errorMessage);
		}
		return Response.status(Status.OK).entity(customersResponse).build();
	}

	/**
	 * Create Customers API.
	 */
	@POST
	@Path("/customers")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createCustomers(@RequestBody CustomerRequest customersRequest) {
		CustomerResponse customerResponse = null;
		try {
			customerResponse = this.bootstrapDelegator.createCustomer(customersRequest.getCustomer());
		} catch (BootstrapDelegatorException e) {
			LOGGER.error(e.getMessage(), e);
			return errorResponseHelper.makeErrorResponse(e.getMessage());
		} catch (Exception e) {
			String errorMessage = "Internal server error while creating Customers.";
			LOGGER.error(errorMessage, e);
			return errorResponseHelper.makeErrorResponse(errorMessage);
		}
		return Response.status(Status.OK).entity(customerResponse).build();
	}
}
