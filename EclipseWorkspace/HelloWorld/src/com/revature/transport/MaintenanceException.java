package com.revature.transport;

public class MaintenanceException extends Exception {

	public MaintenanceException() {
		super();
	}

	public MaintenanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MaintenanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintenanceException(String message) {
		super(message);
	}

	public MaintenanceException(Throwable cause) {
		super(cause);
	}
	
}
