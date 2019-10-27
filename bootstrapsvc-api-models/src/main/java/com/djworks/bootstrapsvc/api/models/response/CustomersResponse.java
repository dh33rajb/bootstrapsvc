package com.djworks.bootstrapsvc.api.models.response;

import java.util.List;

import com.djworks.bootstrapsvc.api.datatype.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomersResponse extends BootstrapResponse {
	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
