package com.djworks.bootstrapsvc.api.models.response;

import com.djworks.bootstrapsvc.api.models.response.metadata.BootstrapResponseMetadata;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Class that holds any API level metadata and misc. information, like
 * diagnostics.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BootstrapResponse {

	private BootstrapResponseMetadata metadata;

	public BootstrapResponseMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(BootstrapResponseMetadata metadata) {
		this.metadata = metadata;
	}
}
