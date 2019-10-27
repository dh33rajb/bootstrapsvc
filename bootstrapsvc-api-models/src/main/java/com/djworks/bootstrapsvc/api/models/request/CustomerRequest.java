package com.djworks.bootstrapsvc.api.models.request;

import com.djworks.bootstrapsvc.api.datatype.Customer;

public class CustomerRequest {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
