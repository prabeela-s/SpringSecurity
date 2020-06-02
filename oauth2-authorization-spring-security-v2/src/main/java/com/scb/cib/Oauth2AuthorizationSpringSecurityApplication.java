package com.scb.cib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@ComponentScan({"com.scb.cib"})
public class Oauth2AuthorizationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationSpringSecurityApplication.class, args);
	}

}
