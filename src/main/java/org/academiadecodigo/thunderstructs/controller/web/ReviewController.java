package org.academiadecodigo.thunderstructs.controller.web;

import org.academiadecodigo.thunderstructs.converters.ReviewDtoToReview;
import org.academiadecodigo.thunderstructs.converters.ReviewToReviewDto;
import org.academiadecodigo.thunderstructs.dto.ReviewDTO;
import org.academiadecodigo.thunderstructs.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "/api/review" )
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

	@RequestMapping ( method = RequestMethod.GET )
	public ResponseEntity< List< ReviewDTO > > listReviews ( String name ) {
		if(reviewService.list( name ) == null ){
			return new ResponseEntity<>( HttpStatus.NOT_FOUND );
		}
		return new ResponseEntity<>( reviewToReviewDto.convertList( reviewService.list( name ) ) , HttpStatus.OK);
	}

}