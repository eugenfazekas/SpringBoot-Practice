package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
	
	 @Bean
	    public SecurityWebFilterChain springSecurityFilterChain(
	      ServerHttpSecurity http) {
	        http.csrf().disable()
	          .authorizeExchange()
	          .pathMatchers("/users").permitAll()
	          .and()
	          .httpBasic();
	        return http.build();
	    }

}
