package com.github.popemay.config;

import java.net.UnknownHostException;

import javax.management.Query;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.popemay.service.Password;
import com.mongodb.MongoClient;

@Configuration
public class BeanConfig {
	public static final String DB_NAME = "toyexchange";

	private static final int MONGO_PORT = 27017;
	private static final String MONGO_HOST = "localhost";

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(new MongoClient(MONGO_HOST, MONGO_PORT), DB_NAME);
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public EmailValidator emailValidator() {
		return new EmailValidator();
	}
	
	
	@Bean
	public Password password(){
		return new Password();
	}
}
