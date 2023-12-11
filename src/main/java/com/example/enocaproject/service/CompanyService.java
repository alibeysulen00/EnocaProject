package com.example.enocaproject.service;

import com.example.enocaproject.model.dto.CompanyDto;
import com.example.enocaproject.model.entity.Company;
import com.example.enocaproject.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CompanyDto> getAllCompanyMethod(){

        List<Company> companyList = companyRepository.findAll();
        List<CompanyDto> companyDtos = companyList.stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
        return companyDtos;
    }

    public ResponseEntity<String> addCompanyMethod(Company company) {
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company Added Successfully");

    }


}
