package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.CompanyDTO;
import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CompanyToCompanyDto {

    private ReviewToReviewDto toReviewDto;

    @Autowired
    public void setToReviewDto(ReviewToReviewDto toReviewDto) {
        this.toReviewDto = toReviewDto;
    }

    public CompanyDTO convert(CompanyModel model) {

        CompanyDTO dto = new CompanyDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setReviews(model.getReviews());
        dto.setRating( model.getRating() );
        dto.setDays( model.getDays() );
        return dto;
    }

    public List<CompanyDTO> convertList(List<CompanyModel> companyModels){

        List<CompanyDTO> companyDTOS = new LinkedList<>(  );

        for ( CompanyModel model :
               companyModels  ) {
            companyDTOS.add( convert( model ) );
        }
        return companyDTOS;
    }
}
