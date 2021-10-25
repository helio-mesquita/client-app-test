package com.heliomesquita.dev.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.heliomesquita.dev.client.services.UserService;

@Controller
public class UserResource {
	
	@Autowired
	UserService userServices;
}
