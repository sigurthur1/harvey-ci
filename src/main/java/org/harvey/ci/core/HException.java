package org.harvey.ci.core;

public class HException extends Exception {
	private static final long serialVersionUID = 7883976160187140142L;

	public HException(String message, Throwable cause) {
		super(message, cause);
	}

	public HException(String message) {
		super(message);
	}

	public HException(Throwable cause) {
		super(cause);
	}
}
