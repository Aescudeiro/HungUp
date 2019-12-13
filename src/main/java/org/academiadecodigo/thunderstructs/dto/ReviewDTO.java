package org.academiadecodigo.thunderstructs.dto;

public class ReviewDTO {

	private Integer id;
	private String name;
	private double rating;
	private Integer days;
	private String review;

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}

	public Integer getDays () {
		return days;
	}

	public void setDays ( Integer days ) {
		this.days = days;
	}

	public Integer getId () {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public double getRating () {
		return rating;
	}

	public void setRating ( double rating ) {
		this.rating = rating;
	}

	public String getReview () {
		return review;
	}

	public void setReview ( String review ) {
		this.review = review;
	}
}
