package com.example.enocaproject.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "employee_name")
    private String employee_name;
    @Column(name = "title")
    private String title;
    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "company_name", referencedColumnName = "name", insertable = false, updatable = false)
    @JsonBackReference
    private Company company1;

}
