package com.djworks.bootstrapsvc.domain.models.response.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteResponseMetadata {

	private PaginationMetadata pagination;

	public PaginationMetadata getPagination() {
		return pagination;
	}

	public void setPagination(PaginationMetadata pagination) {
		this.pagination = pagination;
	}
}
