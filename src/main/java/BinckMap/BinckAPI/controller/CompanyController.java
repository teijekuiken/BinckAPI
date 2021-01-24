package BinckMap.BinckAPI.controller;

import BinckMap.BinckAPI.controller.model.Request.CompanyRequestBody;
import BinckMap.BinckAPI.entity.Company;
import BinckMap.BinckAPI.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<Company> getBuilding(@PathVariable long companyId) {

        Company company = companyService.getCompanyById(companyId);

        return ResponseEntity.ok(company);
    }

    @CrossOrigin
    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllStories() {
        List<Company> companies = companyService.getAllCompanies();

        return ResponseEntity.ok(companies);
    }

    @PostMapping("/company")
    public List<Company> addcompanies(@RequestBody List<CompanyRequestBody> companyRequestBody) {
        return companyService.setCompanies(companyRequestBody);
    }

}

