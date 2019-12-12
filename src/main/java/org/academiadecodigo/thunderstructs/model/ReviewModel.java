package org.academiadecodigo.thunderstructs.model;

public class ReviewModel implements Model {

	private static Integer counter = 0;
	private Integer id;
	private double rating;
	private String review;

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
