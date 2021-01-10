package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.Interfaces.ICompanyRequestBody;
import BinckMap.BinckAPI.Interfaces.ICompanyResponseBody;
import BinckMap.BinckAPI.controller.model.Request.BuildingRequestBody;
import BinckMap.BinckAPI.controller.model.Request.CompanyRequestBody;
import BinckMap.BinckAPI.entity.Building;
import BinckMap.BinckAPI.entity.Company;
import BinckMap.BinckAPI.services.BuildingServices;
import BinckMap.BinckAPI.services.CompanyService;
import BinckMap.BinckAPI.services.model.BuildingResponseBody;
import BinckMap.BinckAPI.services.model.CompanyResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<Company> getBuilding(@PathVariable long buildingId) {

        Company company = companyService.getCompanyById(buildingId);

        return ResponseEntity.ok(company);
    }

    @CrossOrigin
    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllStories() {
        List<Company> companies = companyService.getAllCompanies();

        return ResponseEntity.ok(companies);
    }

    @PostMapping("/company")
    public CompanyResponseBody addcompany(@RequestBody CompanyRequestBody companyRequestBody) {
        return companyService.setCompany(companyRequestBody);
    }

}

