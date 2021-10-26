package com.heliomesquita.dev.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heliomesquita.dev.client.entities.User;
import com.heliomesquita.dev.client.services.UserService;


@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		
		System.out.println(UserService.findUser(1L));
		
		UserService.printAllUsers();
		
		User user = new User(12L, "Magno Alves", "magnata@gmail.com", "991919191", "1234567");
		
		UserService.postUser(user);
		
		System.out.println();
		System.out.println("Lista atualizada: ");
		UserService.printAllUsers();
		
		User userPut = new User(12L, "Clodoaldo", "clodoaldo@gmail.com", "994949494", "123456");
		
		UserService.updateUserbyId(userPut.getId(), userPut);
		
		System.out.println();
		System.out.println("Lista atualizada: ");
		UserService.printAllUsers();
				
		System.out.println();
		UserService.deleteUserById(2l);
		
		System.out.println();
		System.out.println("Lista atualizada: ");
		UserService.printAllUsers();
		
		
	}

}
