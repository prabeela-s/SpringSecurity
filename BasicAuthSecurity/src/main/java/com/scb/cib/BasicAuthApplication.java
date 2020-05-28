package com.scb.cib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({"com.scb.cib.controller","com.scb.cib"})
public class BasicAuthApplication {

	@Bean
    public com.scb.cib.persistence.UserRepository userRepository() {
        return new com.scb.cib.persistence.InMemoryUserRepository();
    }

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

}
