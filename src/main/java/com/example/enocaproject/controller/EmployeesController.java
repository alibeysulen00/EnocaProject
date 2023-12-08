package com.example.enocaproject.controller;


import com.example.enocaproject.model.entity.Employees;
import com.example.enocaproject.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/allEmployee")
    public List<Employees> getAllEmployee() {
       return employeesService.getAllEmployeeMethod();
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employees employees){
        return employeesService.addEmployeeMethod(employees);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employees employees){
        return employeesService.updateEmployeeMethod(id, employees);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        return employeesService.deleteEmployeeMethod(id);
    }
}
