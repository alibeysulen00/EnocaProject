package com.example.enocaproject.repository;

import com.example.enocaproject.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
