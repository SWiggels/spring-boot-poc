package com.tasc.golden.common.exception;

/**
 * Base abstract exception for TASC java exceptions.
 */
public abstract class AbstractTascException extends RuntimeException {

	private static final long serialVersionUID = 5176007805134863994L;

	public AbstractTascException(String message) {
		super(message);
	}

	public AbstractTascException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractTascException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
