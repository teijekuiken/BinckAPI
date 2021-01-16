package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.CompanyRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.controller.model.Request.CompanyRequestBody;
import BinckMap.BinckAPI.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company getCompanyById(long companyId){
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isEmpty()){
            return null;
        }
        return company.get();
    }

    public Company getCompanyByName(String name, List<Company> companies){
        for (Company company : companies){
            company.getName().equals(name);{
                return company;
            }
        } return null;
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    public List<Company> setCompanies(List<CompanyRequestBody> companyRequestBodies) {

        List<Company> companies = new ArrayList();

        for(CompanyRequestBody companyRequestBody : companyRequestBodies){
            Company company = new Company();
            company.setName(companyRequestBody.getName());
            company.setLabelType(companyRequestBody.getLabelType());
            company.setOntwikkelaar(companyRequestBody.getOntwikkelaar());
            company.setStatus(companyRequestBody.getStatus());
            company.setProgramma(companyRequestBody.getProgramma());
            company.setStatus(companyRequestBody.getStatus());
            company.setDescription(companyRequestBody.getDescription());
            company.setLat1(companyRequestBody.getLat1());
            company.setLong1(companyRequestBody.getLong1());
            company.setLat2(companyRequestBody.getLat2());
            company.setLong2(companyRequestBody.getLong2());

            companies.add(company);
            companyRepository.save(company);
        }

        return companies;

    }

}
