package org.spring.sample.beanxml;

public class HelloWorldXmlBean {
	 private String message;

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }

}
