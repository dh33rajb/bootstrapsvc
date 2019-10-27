package com.djworks.bootstrapsvc.api.models.response.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BootstrapResponseMetadata {

	public BootstrapResponseMetadata(PaginationMetadata pagination) {
		this.pagination = pagination;
	}

	private PaginationMetadata pagination;

	public PaginationMetadata getPagination() {
		return pagination;
	}

	public void setPagination(PaginationMetadata pagination) {
		this.pagination = pagination;
	}
}
