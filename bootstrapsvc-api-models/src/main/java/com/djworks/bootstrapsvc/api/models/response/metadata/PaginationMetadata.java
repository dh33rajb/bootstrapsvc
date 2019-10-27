package com.djworks.bootstrapsvc.api.models.response.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaginationMetadata {

	private int limit;

	private int offset;

	private boolean hasNext;

	public PaginationMetadata(int limit, int offset, boolean hasNext) {
		this.limit = limit;
		this.offset = offset;
		this.hasNext = hasNext;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
