package com.lcwd.user.service.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
//import com.lcwd.user.service.UserSevice.exception.ResourseNotFoundException;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourseNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService {
	
@Autowired
private UserRepository userRepository;

@Autowired
private RestTemplate restTemplate ;

@Autowired
private HotelService hotelService;

private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

public User saveUser (User user) {
	String randomUserId  = UUID.randomUUID().toString();
	user.setUserId(randomUserId);
	return userRepository.save(user);

}



public List<User> getAllUser() {
return userRepository.findAll();
}


public User getUser(String userId) {
	
	User user = userRepository.findById(userId).orElseThrow(()->new ResourseNotFoundException("User with given id not found"));
	System.out.println("fghfghfghfghfghfhg");
	Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId , Rating[].class);
	
	List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

	List<Rating> ratingList = ratings.stream()
		    .map(rating -> {
		    	
//		        ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
		        Hotel hotel = hotelService.getHotel(rating.getHotelId());

//		    	Hotel hotel = forEntity.getBody();
		        rating.setHotel(hotel);
		        return rating;
		    })
		    .collect(Collectors.toCollection(ArrayList::new));
	
       user.setRatings(ratingList);
	
	return user;
	}
}
