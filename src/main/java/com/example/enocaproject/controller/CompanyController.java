package com.example.enocaproject.controller;

import com.example.enocaproject.model.entity.Company;
import com.example.enocaproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/allCompany")
    public List<Company> getAllCompany(){
        return companyService.getAllCompanyMethod();
    }

    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        return companyService.addCompanyMethod(company);
    }


}
