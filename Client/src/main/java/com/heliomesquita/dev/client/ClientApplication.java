package com.heliomesquita.dev.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heliomesquita.dev.client.services.UserService;


@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		
		System.out.println(UserService.findUser(1L));
		
		UserService.printAllUser();
	}

}
