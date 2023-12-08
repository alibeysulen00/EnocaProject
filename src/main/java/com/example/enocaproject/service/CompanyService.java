package com.example.enocaproject.service;

import com.example.enocaproject.model.entity.Company;
import com.example.enocaproject.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanyMethod(){

        return companyRepository.findAll();
    }

    public ResponseEntity<String> addCompanyMethod(Company company) {
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company Added Successfully");

    }


}
