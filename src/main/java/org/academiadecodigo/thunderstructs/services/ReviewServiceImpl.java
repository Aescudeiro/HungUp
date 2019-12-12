package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewModel reviewModel;
	private CompanyModel companyModel;

	@Autowired
	public void setReviewModel ( ReviewModel reviewModel ) {
		this.reviewModel = reviewModel;
	}

	@Override
	public ReviewModel get ( Integer id ) {
		return null;
	}

	@Override
	public double getRating ( Integer id ) {
		return 0;
	}

	@Override
	public String getReview ( Integer id ) {
		return null;
	}

	@Override
	public ReviewModel save ( ReviewModel reviewModel ) {
		return null;
	}

	@Override
	public void delete ( Integer id ) {

	}

	@Override
	public List< ReviewModel > list () {
		return null;
	}
}
