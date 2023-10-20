package com.ims.orderservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private int status;

	public CustomException(String message, String errorCode, int status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}

}
