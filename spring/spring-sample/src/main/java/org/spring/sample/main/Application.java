package org.spring.sample.main;

import java.io.File;

import org.spring.sample.annotation.MessagePrinter;
import org.spring.sample.annotation.MessageService;
import org.spring.sample.beanxml.HelloWordService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan
public class Application {

	public static void main(String[] args) {

		/* Anootation */
		ApplicationContext contextAnotation = new ClassPathXmlApplicationContext("anotation.xml");

		/* using xml defionation */
		@SuppressWarnings("deprecation")
		ConfigurableListableBeanFactory context = new XmlBeanFactory(
				new ClassPathResource(File.separator + "Beans.xml"));
		
		HelloWordService objA = (HelloWordService) context.getBean("helloWorldService");
		objA.setMessage("I'm object A");
		objA.getMessage();

		context.setParentBeanFactory(contextAnotation);

		MessageService messageService = (MessageService) context.getBean("messageService");
		MessagePrinter messagePrinter = (MessagePrinter) context.getBean("messagePrinter");
		messagePrinter.printMessage();

	}

}
