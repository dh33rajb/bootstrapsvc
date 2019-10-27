package com.djworks.bootstrapsvc.domain.models.response;

import java.util.List;

import com.djworks.bootstrapsvc.domain.datatype.Customer;
import com.djworks.bootstrapsvc.domain.models.response.metadata.RemoteResponseMetadata;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomersResponse {

	private List<Customer> customers;

	private RemoteResponseMetadata metadata;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public RemoteResponseMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(RemoteResponseMetadata metadata) {
		this.metadata = metadata;
	}
}
