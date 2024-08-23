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

import com.example.demo.entity.Rating;
import com.example.demo.implservice.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Rating createRating(@RequestBody Rating rating) {
		return this.service.createRating(rating);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Rating> getAllRating(){
		return this.service.getAllRatings();
	}
	
	@GetMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Rating> getRatingByUser(@PathVariable String userId){
		return this.service.getRatingByUserId(userId);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public List<Rating> getRatingByHotel(@PathVariable String hotelId){
		return this.service.getRatingByHotelId(hotelId);
	}
	
}
