package com.api.busmaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.busmaster.models.Rider;
import com.api.busmaster.services.RiderService;

@Controller
public class RiderController {
	@Autowired
	private RiderService riderService;
	
	@GetMapping("/api/getrider")
	public Rider getRider() {
		return riderService.getRider();
	}
}
