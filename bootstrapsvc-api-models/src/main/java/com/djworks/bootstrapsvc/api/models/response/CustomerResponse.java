package com.djworks.bootstrapsvc.api.models.response;

import com.djworks.bootstrapsvc.api.datatype.Customer;

public class CustomerResponse extends BootstrapResponse {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
