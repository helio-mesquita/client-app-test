package com.heliomesquita.dev.client.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.heliomesquita.dev.client.entities.User;

@Service
public class UserService {

	public static User findUser(Long id) {

		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080")
				.basicAuthentication("teste", "password").build();
		User user = restTemplate.getForObject("/users/" + id, User.class);

		return user;
	}

	public static User[] findUsersList() {

		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080")
				.basicAuthentication("teste", "password").build();

		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("/users", User[].class);
		User[] user = responseEntity.getBody();

		return user;

	}

	public static void printAllUsers() {
		User[] user = UserService.findUsersList();
		for (int i = 0; i < user.length; i++) {
			System.out.println(user[i]);
		}
		System.out.println();
	}

	public static void postUser(User user) {

		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080")
				.basicAuthentication("teste", "password").build();

		restTemplate.postForObject("/users", user, User.class);
		System.out.println("Usuário adicionado: \n" + user);
	}

	public static void deleteUserById(Long id) {

		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080")
				.basicAuthentication("teste", "password").build();
		User user = UserService.findUser(id);
		restTemplate.delete("/users/" + id);
		System.out.println("Usuário deletado: \n" + user);
	}

	public static void updateUserbyId(Long id, User user) {
		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080")
				.basicAuthentication("teste", "password").build();
		restTemplate.put("/users/" + id, user);
		System.out.println("Usuário atualizado: \n" + user);
	}

}
