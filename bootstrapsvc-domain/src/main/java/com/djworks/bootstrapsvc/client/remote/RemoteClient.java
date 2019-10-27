package com.djworks.bootstrapsvc.client.remote;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.djworks.bootstrapsvc.domain.datatype.Customer;
import com.djworks.bootstrapsvc.domain.models.response.CustomerResponse;
import com.djworks.bootstrapsvc.domain.models.response.CustomersResponse;
import com.djworks.bootstrapsvc.util.JsonFileReader;
import com.djworks.bootstrapsvc.util.JsonFileReaderException;

@Component
public class RemoteClient {

	private static final int CLIENT_READ_TIMEOUT = 1000;

	private static final int CLIENT_CONNECT_TIMEOUT = 1000;

	private static final String REMOTE_SERVICE_BASE_URI = "http://localhost:8090";

	private static final String CUSTOMERS_RESOURCE_PATH = "stubsvc/v1/stub/customers";

	private static final String AUTH_TOKEN = "SAMPLE_AUTH_TOKEN";

	private Client client;

	private WebTarget base;

	@Autowired
	private JsonFileReader jsonFileReader;

	private static final String SAMPLE_CREATE_CUSTOMERS_RESPONSE_FILE_PATH = "responses/sample_create_customer_response.json";

	@PostConstruct
	private void initClient() {
		client = ClientBuilder.newClient().property(ClientProperties.CONNECT_TIMEOUT, CLIENT_CONNECT_TIMEOUT)
				.property(ClientProperties.READ_TIMEOUT, CLIENT_READ_TIMEOUT);
		base = client.target(REMOTE_SERVICE_BASE_URI);
	}

	@PreDestroy
	public void closeClient() {
		if (client != null) {
			client.close();
		}
	}

	/**
	 * Get customer from remote service.
	 */
	public CustomersResponse getCustomers() {
		CustomersResponse customers = null;
		try {
			WebTarget details = base.path(CUSTOMERS_RESOURCE_PATH);
			customers = details.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, AUTH_TOKEN)
					.get(new GenericType<CustomersResponse>() {
					});
		} catch (Exception e) {
			throw new RemoteClientException("Error getting data from remote client.", e);
		}
		return customers;
	}

	/**
	 * Create customer, by reading from a local file.
	 */
	public Customer createCustomerLocally(Customer customer) {
		Customer createdCustomer = null;
		try {
			CustomerResponse customerResponse = this.jsonFileReader.readJson(SAMPLE_CREATE_CUSTOMERS_RESPONSE_FILE_PATH,
					CustomerResponse.class);
			createdCustomer = customerResponse != null ? customerResponse.getCustomer() : null;
		} catch (JsonFileReaderException e) {
			throw new RemoteClientException(e.getMessage(), e);
		} catch (Exception e) {
			throw new RemoteClientException(e);
		}
		return createdCustomer;
	}
}
