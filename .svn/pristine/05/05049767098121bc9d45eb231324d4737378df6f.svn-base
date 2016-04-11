package com.koomoni.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String errCode, String message) {
		super(message);
		this.errorCode = errCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
