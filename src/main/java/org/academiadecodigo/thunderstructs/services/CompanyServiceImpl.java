package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.academiadecodigo.thunderstructs.model.ReviewModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private List<CompanyModel> companies;

    public CompanyServiceImpl() {
        this.companies = new LinkedList<>();
        CompanyModel companyModel = new CompanyModel();
        companyModel.setId( 1 );
        companyModel.setName( "ola" );

        ReviewModel review = new ReviewModel();
        review.setReview( "ahahah" );
        review.setRating( 4 );
        review.setId( 1 );
        companyModel.addReview( review );

        ReviewModel review1 = new ReviewModel();
        review1.setReview( "ola3" );
        review1.setRating( 4 );
        review1.setId( 2 );
        companyModel.addReview( review1 );

        companies.add( companyModel );

    }

    @Override
    public List<CompanyModel> getCompanies() {
        return this.companies;
    }

    @Override
    public CompanyModel getCompany(String name) {
        CompanyModel target = null;

        for(CompanyModel company : companies){
            if(company.getName() == name){
                target = company;
                break;
            }
        }

        return target;
    }

    @Override
    public void addCompany(CompanyModel company) {
        companies.add(company);
    }
}
