package com.example.demo.implService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repositor.HotelRepository;
import com.example.demo.service.HotelService;

@Service
public class HotelImplService implements HotelService{

	@Autowired
	HotelRepository hoteRepo;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String s=UUID.randomUUID().toString();
		hotel.setId(s);
		return hoteRepo.save(hotel);
	}

	@Override
	public Hotel getSingleHotel(String id) {
		// TODO Auto-generated method stub
		return hoteRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hoteRepo.findAll();
	}

}
