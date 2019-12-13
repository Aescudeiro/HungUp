package org.academiadecodigo.thunderstructs.controller;


import org.academiadecodigo.thunderstructs.converters.CompanyDtoToCompany;
import org.academiadecodigo.thunderstructs.converters.CompanyToCompanyDto;
import org.academiadecodigo.thunderstructs.dto.CompanyDTO;
import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.academiadecodigo.thunderstructs.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping ( "/api/company" )
public class CompanyController {

	private CompanyDtoToCompany companyDtoToCompany;
	private CompanyToCompanyDto companyToCompanyDto;
	private CompanyService companyService;

	@Autowired
	public void setCompanyDtoToCompany ( CompanyDtoToCompany companyDtoToCompany ) {
		this.companyDtoToCompany = companyDtoToCompany;
	}

	@Autowired
	public void setCompanyToCompanyDto ( CompanyToCompanyDto companyToCompanyDto ) {
		this.companyToCompanyDto = companyToCompanyDto;
	}

	@Autowired
	public void setCompanyService ( CompanyService companyService ) {
		this.companyService = companyService;
	}

	@RequestMapping ( method = RequestMethod.GET )
	public ResponseEntity< List< CompanyDTO > > getCompanyList () {
		for(CompanyModel companyModel : companyService.getCompanies()) {
			companyService.update( companyModel.getName() );
		}
		return new ResponseEntity<>( companyToCompanyDto.convertList( companyService.getCompanies() ), HttpStatus.OK );
	}

	@RequestMapping ( method = RequestMethod.GET, path = "/{name}" )
	public ResponseEntity< CompanyDTO > getCompany ( @PathVariable String name ) {
		for ( CompanyModel model : companyService.getCompanies() ) {
			if ( model.getName().equals( name ) ) {
				return new ResponseEntity<>( companyToCompanyDto.convert( model ), HttpStatus.OK );

			}
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND );
	}

	@RequestMapping (method = RequestMethod.GET, path = "/{name}/review")
	public ResponseEntity<List< ReviewModel >> getReviewList(@PathVariable String name) {
		for ( CompanyModel model : companyService.getCompanies() ) {
			if ( model.getName().equals( name ) ) {
				companyService.update( model.getName() );
				return new ResponseEntity<>( model.getReviews(),HttpStatus.OK );
			}
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND );
	}

	@RequestMapping (method = RequestMethod.GET, path = "/{name}/review/{id}")
	public ResponseEntity<ReviewModel> getReview(@PathVariable String name, @PathVariable Integer id){
		for ( CompanyModel model : companyService.getCompanies() ) {
			if ( model.getName().equals( name ) ) {
				for ( ReviewModel r : model.getReviews()) {
					if (r.getId().equals( id )){
						return new ResponseEntity<>( r,HttpStatus.OK );
					}
				}
			}
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND );
	}

	@RequestMapping ( method = RequestMethod.POST )
	public ResponseEntity< CompanyDTO > addCompany ( @RequestBody CompanyDTO companyDTO ) {
		CompanyModel model = companyDtoToCompany.convert( companyDTO );
		companyDTO.setId( model.getId() );
		companyService.addCompany( model );
		return new ResponseEntity<>( companyDTO, HttpStatus.CREATED );
	}

	@RequestMapping (method = RequestMethod.POST, path = "/{name}/review")
	public ResponseEntity<ReviewModel> addReview(@RequestBody ReviewModel reviewModel, @PathVariable String name) {
		ReviewModel reviewModel1 = reviewModel;
		for ( CompanyModel model : companyService.getCompanies() ) {
			if ( model.getName().equals( name ) ) {
				model.addReview( reviewModel );
				companyService.update( model.getName() );
				return new ResponseEntity<>( reviewModel, HttpStatus.CREATED );
			}
		}
		return new ResponseEntity<>( reviewModel, HttpStatus.BAD_REQUEST );
	}
}