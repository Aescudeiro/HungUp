package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.ReviewDTO;
import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ReviewToReviewDto {

	public ReviewDTO convert ( ReviewModel reviewModel ) {

		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setId( reviewModel.getId() );
		reviewDTO.setRating( reviewModel.getRating() );
		reviewDTO.setReview( reviewModel.getReview() );
		return reviewDTO;

	}

	public List< ReviewDTO > convertList ( List< ReviewModel > reviewModelList ) {

		List< ReviewDTO > reviewDTOList = new LinkedList<>();

		for ( ReviewModel r : reviewModelList ) {
			reviewDTOList.add( convert( r ) );
		}

		return reviewDTOList;
	}
}