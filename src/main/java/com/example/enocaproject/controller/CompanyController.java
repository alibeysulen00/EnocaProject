package com.example.enocaproject.controller;

import com.example.enocaproject.model.dto.CompanyDto;
import com.example.enocaproject.model.entity.Company;
import com.example.enocaproject.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/allCompany")
    public List<CompanyDto> getAllCompany(){
        return companyService.getAllCompanyMethod();
    }

    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompany(@RequestBody CompanyDto companyDto){
        Company newCompany = modelMapper.map(companyDto, Company.class);
        return companyService.addCompanyMethod(newCompany);
    }


}
