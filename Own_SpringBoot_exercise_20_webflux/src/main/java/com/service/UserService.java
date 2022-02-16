package com.service;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.model.User;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

@Service
public class UserService {

	private WebClient webClient;
	
	HttpClient httpClient = HttpClient.create()
			  .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
			  .responseTimeout(Duration.ofMillis(5000))
			  .doOnConnected(conn -> 
			    conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
			        .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
	
	
	public UserService() {
		
	this.webClient =	WebClient.builder()
		  .baseUrl("https://jsonplaceholder.typicode.com/")
		  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
		  .clientConnector(new ReactorClientHttpConnector(httpClient))
		  .build();
	}
	
	public Flux<User> getUsers() {		
		return webClient.get()
					  .uri("users")
					  .retrieve()
					  .bodyToFlux(User.class);
		}

	
}
