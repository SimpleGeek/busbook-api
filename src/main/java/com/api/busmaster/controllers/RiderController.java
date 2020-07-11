package com.api.busmaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.busmaster.models.Rider;
import com.api.busmaster.services.RiderService;

@RestController
public class RiderController {
	@Autowired
	private RiderService riderService;
	
	@GetMapping("/api/getrider")
	public Rider getRider() {
		return riderService.getRider();
	}
	
	@GetMapping("/api/getriders")
	public List<Rider> getRiders() {
		return riderService.getRiders();
	}
}
