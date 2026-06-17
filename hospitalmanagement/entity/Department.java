package com.stickytechnologies.hospitalmanagement.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String Departments;

    @OneToMany(mappedBy = "cardioDepartment")
    @JsonManagedReference
    private List<Doctors> doctors;


    private Integer total_doctors;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Nurses> nurses;

    private Integer total_nurses;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Salary> salaries;


    private Integer total_sweepers;

    private  Double Department_Fund;

    private Double Total_salaries_amount;
}
