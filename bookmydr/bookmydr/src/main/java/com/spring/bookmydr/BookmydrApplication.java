package com.spring.bookmydr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.spring.bookmydr")
@SpringBootApplication
public class BookmydrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmydrApplication.class, args);
	}

}
