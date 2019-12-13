package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.CompanyDTO;
import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CompanyDtoToCompany {

	public CompanyModel convert ( CompanyDTO dto ) {
		CompanyModel model = new CompanyModel();

		if ( dto.getName() != null ) {
			model.setName( dto.getName() );
		}

		if ( dto.getReviews() != null ) {
			model.setReviews( dto.getReviews() );
		}

		model.setRating( dto.getRating() );

		if ( dto.getDays() != null ) {
			model.setDays( dto.getDays() );
		}
		return model;
	}

	public List< CompanyModel > converList ( List< CompanyDTO > companyDTOS ) {
		List< CompanyModel > companyModels = new LinkedList<>();
		for ( CompanyDTO dto :
				companyDTOS ) {
			companyModels.add( convert( dto ) );
		}
		return companyModels;
	}

}
