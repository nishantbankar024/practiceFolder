package com.example.demo.excepption;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("resource not found exception :");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
