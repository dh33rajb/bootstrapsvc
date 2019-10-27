package com.djworks.bootstrapsvc.client.transformer;

import org.springframework.stereotype.Component;

import com.djworks.bootstrapsvc.api.datatype.Customer;
import com.google.common.base.Function;

@Component("remoteCustomerTransformer")
public class CustomerTransformer implements Function<Customer, com.djworks.bootstrapsvc.domain.datatype.Customer> {

	@Override
	public com.djworks.bootstrapsvc.domain.datatype.Customer apply(Customer apiCustomer) {
		if (apiCustomer == null) {
			return null;
		}
		com.djworks.bootstrapsvc.domain.datatype.Customer remoteCustomer = new com.djworks.bootstrapsvc.domain.datatype.Customer();
		remoteCustomer.setCustomerId(apiCustomer.getCustomerId());
		remoteCustomer.setCustomerName(apiCustomer.getCustomerName());
		remoteCustomer.setPhoneNumber(apiCustomer.getPhoneNumber());
		remoteCustomer.setEmailId(apiCustomer.getEmailId());
		remoteCustomer.setSegment(apiCustomer.getSegment());
		return remoteCustomer;
	}
}
