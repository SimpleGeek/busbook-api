package com.api.busmaster.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.busmaster.models.User;

@RestController
public class UserController {
	@GetMapping("/api/users/authenticate")
	public User authenticate() {
		return new User(true);
	}
}
