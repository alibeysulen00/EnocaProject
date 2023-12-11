package com.example.enocaproject.service;

import com.example.enocaproject.model.dto.EmployeesDto;
import com.example.enocaproject.model.entity.Employees;
import com.example.enocaproject.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;



    public List<EmployeesDto> getAllEmployeeMethod() {

        List<Employees> employeesList = employeesRepository.findAll();
        List<EmployeesDto> employeesDto = employeesList.stream()
                .map(employees -> new EmployeesDto(employees.getEmployee_name(), employees.getTitle(), employees.getCompanyName()))
                .collect(java.util.stream.Collectors.toList());
        return employeesDto ;
    }

    public ResponseEntity<String> addEmployeeMethod(Employees employees) {
        Employees newEmployee = new Employees();
        newEmployee.setEmployee_name(employees.getEmployee_name());
        newEmployee.setTitle(employees.getTitle());
        newEmployee.setCompanyName(employees.getCompanyName());
        employeesRepository.save(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added Successfully");
    }

    public ResponseEntity<String> updateEmployeeMethod(int id, Employees employees) {
        Employees updateEmployees = employeesRepository.findById(id).get();
        updateEmployees.setEmployee_name(employees.getEmployee_name());
        updateEmployees.setTitle(employees.getTitle());
        updateEmployees.setCompanyName(employees.getCompanyName());
        employeesRepository.save(updateEmployees);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
    }

    public ResponseEntity<String> deleteEmployeeMethod(int id) {
        employeesRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
    }
}

