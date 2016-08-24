package org.spring.sample.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "classpath:app.properties" })
public class SpringConfig {

	@Value("${message}")
	private String message;

	/*@Bean
	MessageService messageService() {
		return new MessageService() {
			public String getMessage() {
				return message;
			}
		};
	}*/
	
	
}
