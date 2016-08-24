package org.spring.sample.annotation;

public class MessageService {
	private String message;
	
	public MessageService() {
		System.out.println("Initialise MessageService");
	}

	public void setMessage(String message) {
		this.message = message;
	}

	String getMessage() {
		return this.message;
	}

}
