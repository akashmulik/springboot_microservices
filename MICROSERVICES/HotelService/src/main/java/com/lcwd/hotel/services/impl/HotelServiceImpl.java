package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel create (Hotel hotel) {
	
	String hotelId = UUID.randomUUID().toString();
	hotel.setId(hotelId);
	return hotelRepository.save (hotel);
	}
	
	public List<Hotel>getAll() {
	return hotelRepository.findAll();
	}


	
	public Hotel get(String id) {
	
	return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel With Given Id Not Found"));
	}
}
