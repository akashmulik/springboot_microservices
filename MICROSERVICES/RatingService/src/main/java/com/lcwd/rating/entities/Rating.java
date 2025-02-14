package com.lcwd.rating.entities;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {

	@Id
	private String ratingId;
	
	
	private String userId;
	
	
	private String hotelId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;
	
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Rating(String ratingId, String userId, String hotelId, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Rating() {
		super();
	}
	
	
	
}
