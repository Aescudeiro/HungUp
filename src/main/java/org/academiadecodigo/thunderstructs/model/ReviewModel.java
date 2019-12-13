package org.academiadecodigo.thunderstructs.model;

public class ReviewModel implements Model {

	private Integer id;
	private String name;
	private static Integer counter = 0;
	private double rating;
	private String review;
	private Integer days;

	public ReviewModel () {
		this.counter++;
		this.id = this.counter;
	}

	@Override
	public Integer getId () {
		return id;
	}

	@Override
	public void setId (Integer id) {
		this.id = id;
	}

	public Integer getDays () {
		return days;
	}

	public void setDays ( Integer days ) {
		this.days = days;
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
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