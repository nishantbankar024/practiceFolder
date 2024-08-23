package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
//	create user
	public User createUser(User user);
	
//	get singleUser
	public User getSingleUser(String userId);
	
//	get All users
	
	public List<User> getAllUsers();
	

	
	
	
	
	

}
