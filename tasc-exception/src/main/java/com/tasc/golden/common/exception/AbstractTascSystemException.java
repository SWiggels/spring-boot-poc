package com.tasc.golden.common.exception;

public class AbstractTascSystemException extends AbstractTascException {

	private static final long serialVersionUID = -1934598082694764474L;

	public AbstractTascSystemException(String message) {
		super(message);
	}

	public AbstractTascSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractTascSystemException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
