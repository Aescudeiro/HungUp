package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

	private CompanyService companyService;

	@Autowired
	public void setCompanyService ( CompanyService companyService ) {
		this.companyService = companyService;
	}

	@Override
	public ReviewModel get ( Integer id ) {
		return companyService.
	}

	@Override
	public double getRating ( Integer id ) {
		return reviewModel.getRating();
	}

	@Override
	public String getReview ( Integer id ) {
		return reviewModel.getReview();
	}

	@Override
	public void save ( ReviewModel reviewModel ) {
		companyModel.getReviews().add( reviewModel );
	}

	@Override
	public void delete ( Integer id ) {
		for ( ReviewModel r : companyModel.getReviews() ) {
			if( r.getId().equals( id ) ) {
				companyModel.getReviews().remove( r );
			}
		}
	}

	@Override
	public List< ReviewModel > list () {
		return companyModel.getReviews();
	}
}
