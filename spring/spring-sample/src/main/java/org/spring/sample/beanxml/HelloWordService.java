package org.spring.sample.beanxml;

public class HelloWordService {

	HelloWorldXmlBean helloWorldXmlBean;

	public void setHelloWorldXmlBean(HelloWorldXmlBean helloWorldXmlBean) {
		this.helloWorldXmlBean = helloWorldXmlBean;
	}

	@Override
	public String toString() {
		return "helloWorldXmlBean [helloWorldXmlBean=" + helloWorldXmlBean + "]";
	}

	public void setMessage(String message) {
		helloWorldXmlBean.setMessage(message);
	}

	public void getMessage() {
		helloWorldXmlBean.getMessage(); 
	}

}
