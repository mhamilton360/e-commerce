package com.ims.productservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductServiceCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorCode;

	public ProductServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}