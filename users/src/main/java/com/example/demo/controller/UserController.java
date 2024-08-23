package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.implservice.UserImplService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserImplService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUsers(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	@GetMapping("/{userId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public User getSingleUser(@PathVariable String userId) {
		return this.userService.getSingleUser(userId);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}

	

	

}
