package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.implService.HotelImplService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	
	HotelImplService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return service.createHotel(hotel);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Hotel getSingleHotel(@PathVariable String id) {
		return service.getSingleHotel(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List <Hotel> getAllHotel() {
		return service.getAllHotel();
	}

}
