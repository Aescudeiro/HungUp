package org.academiadecodigo.thunderstructs.converters;

import org.academiadecodigo.thunderstructs.dto.CompanyDTO;
import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyDtoToCompany {


    private ReviewDtoToReview toReview;

    @Autowired
    public void setToReview(ReviewDtoToReview toReview) {
        this.toReview = toReview;
    }

    public CompanyModel convert(CompanyDTO dto){
        CompanyModel model = new CompanyModel();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setReviews(toReview.convertList(dto.getReviews()));

        return model;
    }
}
