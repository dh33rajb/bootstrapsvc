package com.djworks.bootstrapsvc.transformer;

import org.springframework.stereotype.Component;

import com.djworks.bootstrapsvc.domain.datatype.Customer;
import com.google.common.base.Function;

@Component
public class CustomerTransformer implements Function<Customer, com.djworks.bootstrapsvc.api.datatype.Customer> {

	@Override
	public com.djworks.bootstrapsvc.api.datatype.Customer apply(Customer remoteCustomer) {
		if (remoteCustomer == null) {
			return null;
		}
		com.djworks.bootstrapsvc.api.datatype.Customer apiCustomer = new com.djworks.bootstrapsvc.api.datatype.Customer();
		apiCustomer.setCustomerId(remoteCustomer.getCustomerId());
		apiCustomer.setCustomerName(remoteCustomer.getCustomerName());
		apiCustomer.setPhoneNumber(remoteCustomer.getPhoneNumber());
		apiCustomer.setEmailId(remoteCustomer.getEmailId());
		apiCustomer.setSegment(remoteCustomer.getSegment());
		return apiCustomer;
	}
}
