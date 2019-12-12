package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.ReviewDTO;
import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ReviewDtoToReview {

	public ReviewModel convert ( ReviewDTO reviewDTO ) {

		ReviewModel reviewModel = new ReviewModel();
		reviewModel.setId( reviewDTO.getId() );
		reviewModel.setRating( reviewDTO.getRating() );
		reviewModel.setReview( reviewDTO.getReview() );
		return reviewModel;

	}

	public List< ReviewModel > convertList ( List< ReviewDTO > reviewDTOList ) {

		List< ReviewModel > reviewModelList = new LinkedList<>();

		for ( ReviewDTO r : reviewDTOList ) {
			reviewModelList.add( convert( r ) );
		}

		return reviewModelList;
	}
}