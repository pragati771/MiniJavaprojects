package com.blogs.exception;

public class ApiResponse extends RuntimeException{
	public ApiResponse(String msg) {
		super(msg);
	}

}
