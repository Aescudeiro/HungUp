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
        companyModel.setName( "Worten" );

        CompanyModel companyModel1 = new CompanyModel();
        companyModel1.setName( "Rádio Popular" );
        companyModel1.setRating( 2 );

        CompanyModel companyModel2 = new CompanyModel();
        companyModel2.setName( "Global Data" );
        companyModel2.setRating( 3 );

        CompanyModel companyModel3 = new CompanyModel();
        companyModel3.setName( "Gear Best" );
        companyModel3.setRating( 1 );

        CompanyModel companyModel4 = new CompanyModel();
        companyModel4.setName( "Amazon" );
        companyModel4.setRating( 1 );

        CompanyModel companyModel5 = new CompanyModel();
        companyModel5.setName( "Ebay" );
        companyModel5.setRating( 5 );

        CompanyModel companyModel6 = new CompanyModel();
        companyModel6.setName( "Ali Express" );
        companyModel6.setRating( 4 );

        ReviewModel review = new ReviewModel();
        review.setName( "Afonso" );
        review.setReview( "ahahah" );
        review.setRating( 4 );
        review.setId( 1 );
        review.setDays(6);
        companyModel.addReview( review );

        ReviewModel review1 = new ReviewModel();
        review1.setName( "Bro" );
        review1.setReview( "ola3" );
        review1.setRating( 4 );
        review1.setId( 2 );
        review1.setDays(3);
        companyModel.addReview( review1 );

        companies.add( companyModel );
        companies.add( companyModel1 );
        companies.add( companyModel2 );
        companies.add( companyModel3 );
        companies.add( companyModel4 );
        companies.add( companyModel5 );
        companies.add( companyModel6 );

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

    @Override
    public void update (String name) {
        for ( CompanyModel companyModel: companies) {
            if(companyModel.getName().equals( name )){
                int day = 0;
                double rating = 0;
                int counter = 0;
                for ( ReviewModel reviewModel : companyModel.getReviews()) {
                    rating += reviewModel.getRating();
                    day += reviewModel.getDays();
                    counter++;
                }
                if(counter == 0){
                    return;
                }
                companyModel.setRating( rating / counter );
                companyModel.setDays( day / counter );
            }
        }
    }
}
