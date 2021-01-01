package BinckMap.BinckAPI.services;

import BinckMap.BinckAPI.DAO.BuildingRepository;
import BinckMap.BinckAPI.DAO.CompanyRepository;
import BinckMap.BinckAPI.DAO.StoryRepository;
import BinckMap.BinckAPI.Interfaces.ICompanyRequestBody;
import BinckMap.BinckAPI.Interfaces.ICompanyResponseBody;
import BinckMap.BinckAPI.controller.model.Request.BuildingRequestBody;
import BinckMap.BinckAPI.controller.model.Request.CompanyRequestBody;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.entity.Company;
import BinckMap.BinckAPI.services.model.BuildingResponseBody;
import BinckMap.BinckAPI.services.model.CompanyResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StoryRepository storyRepository;

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

    public CompanyResponseBody setCompany(CompanyRequestBody companyRequestBody) {
        Company company = new Company(companyRequestBody.getName(), companyRequestBody.getDescription(), companyRequestBody.getLat1(), companyRequestBody.getLong1(), companyRequestBody.getLat2(), companyRequestBody.getLong2());

        companyRepository.save(company);

        CompanyResponseBody companyResponseBody = new CompanyResponseBody(company.getName(), company.getDescription(), company.getLat1(), company.getLong1(), company.getLat2(), company.getLong2());
        return companyResponseBody;
    }

}
