package com.tasc.golden.common.exception;

public class AbstractTascBusinessException extends AbstractTascException {

	private static final long serialVersionUID = -9110970156602098112L;

	public AbstractTascBusinessException(String message) {
		super(message);
	}

	public AbstractTascBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractTascBusinessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
