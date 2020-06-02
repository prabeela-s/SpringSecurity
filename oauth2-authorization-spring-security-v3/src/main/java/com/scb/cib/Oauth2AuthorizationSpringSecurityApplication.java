package com.scb.cib;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@RestController
@SpringBootApplication
@EnableResourceServer
@ComponentScan({"com.scb.cib"})
public class Oauth2AuthorizationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationSpringSecurityApplication.class, args);
	}
	
	//This method will be used to check if the user has a valid token to access the resource
		@RequestMapping("/validateUser")
		public Principal user(Principal user) {
			return user;
		}
		

}
