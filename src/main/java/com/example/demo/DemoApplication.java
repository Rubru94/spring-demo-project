package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* @PropertySource("classpath:values.properties") */
/*
 * @PropertySources({
 * 
 * @PropertySource("classpath:values.properties"),
 * 
 * @PropertySource("classpath:other.properties")
 * })
 */
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
