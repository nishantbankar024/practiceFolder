package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {
	
//	create hotel
	
	public Hotel createHotel(Hotel hotel);
	
//	get single hotel
	
	public Hotel getSingleHotel(String id);
	
//	get all hotel
	
	public List<Hotel> getAllHotel();

}
