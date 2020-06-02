package com.scb.cib;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthorizationConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		System.out.println(passwordEncoder.encode("SECRET"));
		clients.inMemory()
				.withClient("clientapp")
				.authorizedGrantTypes("client_credentials")
				.authorities("USER")
				.scopes("read", "write")
				.secret(passwordEncoder.encode("SECRET"));

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		String idForEncode="bcrypt";
		Map<String,PasswordEncoder> encoderMap=new HashMap();
		encoderMap.put(idForEncode, new BCryptPasswordEncoder());
		
		return new DelegatingPasswordEncoder(idForEncode, encoderMap);
		
		
		
	}

	
}