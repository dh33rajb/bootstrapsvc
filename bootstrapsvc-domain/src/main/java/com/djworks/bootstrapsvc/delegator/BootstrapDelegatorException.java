package com.djworks.bootstrapsvc.delegator;

public class BootstrapDelegatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BootstrapDelegatorException(Throwable throwable) {
		super(throwable);
	}

	public BootstrapDelegatorException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
