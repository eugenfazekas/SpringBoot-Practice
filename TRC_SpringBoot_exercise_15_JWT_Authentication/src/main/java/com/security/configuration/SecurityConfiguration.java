package com.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.security.Repository.UserRepository;
import com.security.service.UserPrincipalDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   	
	 private UserPrincipalDetailsService userPrincipalDetailsService;
	 private UserRepository userRepository;

	    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService,
			UserRepository userRepository) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
	}

		@Override
	    protected void configure(AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(authenticationProvider());
	    }

	 @Override
     protected void configure(HttpSecurity http) throws Exception {
	        http
	        		.csrf().disable()
	        		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        		.and()
	        		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
	        		.addFilter(new JWTAuthorizationFilter(authenticationManager(), userRepository))
	                .authorizeRequests()
	                .antMatchers("/login").permitAll()
	                .antMatchers("/api/public/admin/**").hasAnyRole("ADMIN")
	        		.antMatchers("/api/public/management/**").hasAnyRole("MANAGER");

	    }
	  	   
	 @Bean
	    DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

	        return daoAuthenticationProvider;
	    }

	    @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	}
