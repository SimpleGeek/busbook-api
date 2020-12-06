package com.api.busmaster.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.busmaster.models.User;

@RestController
public class UserController {
	@GetMapping("/api/users/authenticate")
	public User authenticate() {
		User u = new User(true);
		u.addRoute(1);
		return u;
	}
}
