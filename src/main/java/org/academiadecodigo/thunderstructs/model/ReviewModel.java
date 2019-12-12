package org.academiadecodigo.thunderstructs.model;

public class ReviewModel implements Model {

	private Integer id;
	private Integer rating;
	private String review;

	@Override
	public Integer getId () {
		return id;
	}

	@Override
	public void setId (Integer id) {
		this.id = id;
	}

	public Integer getRating () {
		return rating;
	}

	public void setRating ( Integer rating ) {
		this.rating = rating;
	}

	public String getReview () {
		return review;
	}

	public void setReview ( String review ) {
		this.review = review;
	}
}
