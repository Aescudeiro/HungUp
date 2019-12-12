package org.academiadecodigo.thunderstructs.controller.web;

import org.academiadecodigo.thunderstructs.converters.ReviewDtoToReview;
import org.academiadecodigo.thunderstructs.converters.ReviewToReviewDto;
import org.academiadecodigo.thunderstructs.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ( "/review" )
public class ReviewController {

	private ReviewService reviewService;
	private ReviewDtoToReview reviewDtoToReview;
	private ReviewToReviewDto reviewToReviewDto;

	@Autowired
	public void setReviewService ( ReviewService reviewService ) {
		this.reviewService = reviewService;
	}

	@Autowired
	public void setReviewDtoToReview ( ReviewDtoToReview reviewDtoToReview ) {
		this.reviewDtoToReview = reviewDtoToReview;
	}

	@Autowired
	public void setReviewToReviewDto ( ReviewToReviewDto reviewToReviewDto ) {
		this.reviewToReviewDto = reviewToReviewDto;
	}


}