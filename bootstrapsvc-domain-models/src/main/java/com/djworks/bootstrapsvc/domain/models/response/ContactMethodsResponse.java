package com.djworks.bootstrapsvc.domain.models.response;

import java.util.List;

import com.djworks.bootstrapsvc.domain.datatype.ContactMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactMethodsResponse {

	@JsonProperty("contact_methods")
	private List<ContactMethod> contactMethods;

	public List<ContactMethod> getContactMethods() {
		return contactMethods;
	}

	public void setContactMethods(List<ContactMethod> contactMethods) {
		this.contactMethods = contactMethods;
	}

}
