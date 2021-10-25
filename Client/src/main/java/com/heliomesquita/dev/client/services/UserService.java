package com.heliomesquita.dev.client.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.heliomesquita.dev.client.entities.User;

@Service 
public class UserService {

	public static User findUser(Long id) {
		
		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080").basicAuthentication("teste", "password").build();
		User user = restTemplate.getForObject("/users/" + id, User.class);
		
		return user;
	}
}
