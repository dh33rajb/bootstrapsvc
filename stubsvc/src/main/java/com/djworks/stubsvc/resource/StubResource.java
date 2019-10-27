package com.djworks.stubsvc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

@Controller
@Path("/")
public class StubResource {

	@GET
	@Path("/hello")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response hello() {
		return Response.ok("Hello from stub service!").build();
	}

	@GET
	@Path("/stub/{key}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response stub(@PathParam("key") String key) {
		String value = null;
		if (key.equals("customers")) {
			value = "{\"customers\":[{\"customerId\":1111,\"customerName\":\"Jason Bourne\",\"phoneNumber\":1234567890,\"emailId\":\"Jason.Bourne@ebay.com\",\"segment\":\"buyer\"},{\"customerId\":7,\"customerName\":\"James Bond\",\"phoneNumber\":9876543210,\"emailId\":\"James.Bond@ebay.com\",\"segment\":\"seller\"}],\"metadata\":{\"pagination\":{\"limit\":10,\"offset\":0,\"hasNext\":false}}}";
		}
		return Response.ok(value).build();
	}
}
