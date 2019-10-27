package com.djworks.bootstrapsvc.delegator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.djworks.bootstrapsvc.api.datatype.Customer;
import com.djworks.bootstrapsvc.api.models.response.CustomerResponse;
import com.djworks.bootstrapsvc.api.models.response.CustomersResponse;
import com.djworks.bootstrapsvc.api.models.response.metadata.BootstrapResponseMetadata;
import com.djworks.bootstrapsvc.api.models.response.metadata.PaginationMetadata;
import com.djworks.bootstrapsvc.client.remote.RemoteClient;
import com.djworks.bootstrapsvc.client.remote.RemoteClientException;
import com.djworks.bootstrapsvc.transformer.CustomerTransformer;
import com.google.common.collect.Lists;

@Component
public class BootstrapDelegator {

	@Autowired
	private RemoteClient remoteClient;

	@Autowired
	private CustomerTransformer customerTransformer;

	@Autowired
	private com.djworks.bootstrapsvc.client.transformer.CustomerTransformer remoteCustomerTransformer;

	/**
	 * Delegates get-customer calls.
	 */
	public CustomersResponse getCustomers() {
		CustomersResponse customersResponse = new CustomersResponse();
		com.djworks.bootstrapsvc.domain.models.response.CustomersResponse remoteCustomers = null;
		try {
			remoteCustomers = this.remoteClient.getCustomers();
			customersResponse.setCustomers(Lists.transform(remoteCustomers.getCustomers(), this.customerTransformer));
			this.setPaginationMetadata(customersResponse, remoteCustomers);
		} catch (RemoteClientException e) {
			throw new BootstrapDelegatorException(e.getMessage(), e);
		} catch (Exception e) {
			throw new BootstrapDelegatorException("Internal error when talking to remote client.", e);
		}
		return customersResponse;
	}

	private void setPaginationMetadata(CustomersResponse customersResponse,
			com.djworks.bootstrapsvc.domain.models.response.CustomersResponse remoteCustomersResponse) {
		if (paginationMetadataExists(remoteCustomersResponse)) {
			com.djworks.bootstrapsvc.domain.models.response.metadata.PaginationMetadata remotePaginationMetadata = remoteCustomersResponse
					.getMetadata().getPagination();
			customersResponse.setMetadata(
					new BootstrapResponseMetadata(new PaginationMetadata(remotePaginationMetadata.getLimit(),
							remotePaginationMetadata.getOffset(), remotePaginationMetadata.isHasNext())));
		}
	}

	private boolean paginationMetadataExists(
			com.djworks.bootstrapsvc.domain.models.response.CustomersResponse remoteCustomersResponse) {
		return remoteCustomersResponse != null && remoteCustomersResponse.getMetadata() != null
				&& remoteCustomersResponse.getMetadata().getPagination() != null;
	}

	/**
	 * Delegates create-customer calls.
	 */
	public CustomerResponse createCustomer(Customer customer) {
		CustomerResponse apiCustomerResponse = new CustomerResponse();
		try {
			apiCustomerResponse.setCustomer(this.customerTransformer
					.apply(this.remoteClient.createCustomerLocally(this.remoteCustomerTransformer.apply(customer))));
		} catch (RemoteClientException e) {
			throw new BootstrapDelegatorException(e.getMessage(), e);
		} catch (Exception e) {
			throw new BootstrapDelegatorException("Internal error when talking to remote client.", e);
		}
		return apiCustomerResponse;
	}
}
