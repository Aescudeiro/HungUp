package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.CompanyDTO;
import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        dto.setReviews(toReviewDto.convertList(model.getReviews()));

        return dto;
    }
}
