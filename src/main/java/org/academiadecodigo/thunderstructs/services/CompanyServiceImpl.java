package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.model.CompanyModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private List<CompanyModel> companies;

    public CompanyServiceImpl() {
        this.companies = new LinkedList<>();
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
