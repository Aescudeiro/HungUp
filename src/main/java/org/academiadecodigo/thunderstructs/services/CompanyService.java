package org.academiadecodigo.thunderstructs.services;


import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.academiadecodigo.thunderstructs.model.ReviewModel;

import java.util.List;

public interface CompanyService {

    List<CompanyModel> getCompanies();

    CompanyModel getCompany(String name);

    void addCompany(CompanyModel company);

    void updateRating(String cname);
}
