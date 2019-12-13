package org.academiadecodigo.thunderstructs.dto;

import org.academiadecodigo.thunderstructs.model.ReviewModel;

import java.util.List;


public class CompanyDTO {

    private Integer id;
    private String name;
    private double rating;
    private Integer days;
    private List< ReviewModel > reviews;

    public List< ReviewModel > getReviews () {
        return reviews;
    }

    public void setReviews ( List< ReviewModel > reviews ) {
        this.reviews = reviews;
    }

    public double getRating () {
        return rating;
    }

    public void setRating ( double rating ) {
        this.rating = rating;
    }

	public Integer getDays () {
		return days;
	}

	public void setDays ( Integer days ) {
		this.days = days;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
