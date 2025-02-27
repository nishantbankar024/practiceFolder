package com.example.demo.implservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.excepption.ResourceNotFoundException;
//import com.example.demo.internal.service.HotelService;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserImplService implements UserService{

	@Autowired
	public UserRepository userRepo;
	
////	@Autowired
//	public User user;
	
	@Autowired
	public RestTemplate restTemplate;
	
//	@Autowired
//	private HotelService hotelService;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		String s=UUID.randomUUID().toString();
		user.setUserId(s);
		return userRepo.save(user);
	}

	@Override
	public User getSingleUser(String userId) {
		// TODO Auto-generated method stub
		User user= userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("resource not found exception:"+userId));
		
	Rating[] ratingUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.userId, Rating[].class);
	
	List<Rating> ratings=Arrays.stream(ratingUser).toList();
	
	
	List<Rating> ratingList=ratings.stream().map(rating->{
		
		ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		
		Hotel hotel=forEntity.getBody();
//		Hotel hotel=hotelService.getHotel(rating.getHotelId());
		rating.setHotel(hotel);
		return rating;
	}).collect(Collectors.toList());
			
		user.setRatings(ratingList);
		
		
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}





	}



