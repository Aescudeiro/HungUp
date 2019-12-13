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
	public ReviewModel get ( String cname, Integer id ) {
		List< ReviewModel > reviewModels = companyService.getCompany( cname ).getReviews();
		for ( ReviewModel r : reviewModels ) {
			if ( r.getId().equals( id ) ) {
				return r;
			}
		}
		return null;
	}

	@Override
	public double getRating ( String cname, Integer id ) {
		List< ReviewModel > reviewModels = companyService.getCompany( cname ).getReviews();
		for ( ReviewModel r : reviewModels ) {
			if ( r.getId().equals( id ) ) {
				return r.getRating();
			}
		}
		return 0;
	}

	@Override
	public String getReview ( String cname, Integer id ) {
		List< ReviewModel > reviewModels = companyService.getCompany( cname ).getReviews();
		for ( ReviewModel r : reviewModels ) {
			if ( r.getId().equals( id ) ) {
				return r.getReview();
			}
		}
		return null;
	}

	@Override
	public void save ( String cname, ReviewModel reviewModel ) {
		companyService.getCompany( cname ).addReview( reviewModel );
	}

	@Override
	public void delete ( String cname, Integer id ) {
		List< ReviewModel > reviewModels = companyService.getCompany( cname ).getReviews();
		for ( ReviewModel r : reviewModels ) {
			if ( r.getId().equals( id ) ) {
				companyService.getCompany( cname ).getReviews().remove( r );
			}
		}
	}

	@Override
	public List< ReviewModel > list ( String cname ) {
		List< ReviewModel > reviewModels = companyService.getCompany( cname ).getReviews();
		return reviewModels;
	}

}