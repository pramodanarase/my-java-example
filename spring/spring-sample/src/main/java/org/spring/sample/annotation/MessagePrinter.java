package org.spring.sample.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	
	@Autowired(required=false)
	private MessageService service;
	
	private String test="ABC";
	
	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public MessagePrinter() {
		System.out.println("Initialise  MessagePrinter ");
	}

    
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println( this.service.getMessage() + "Test Message:"+ getTest());
    }

}
