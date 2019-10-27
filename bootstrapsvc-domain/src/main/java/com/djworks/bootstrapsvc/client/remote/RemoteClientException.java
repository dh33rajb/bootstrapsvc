package com.djworks.bootstrapsvc.client.remote;

public class RemoteClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RemoteClientException(Throwable throwable) {
		super(throwable);
	}

	public RemoteClientException(String message, Throwable throwable) {
		super(message, throwable);
	}
}