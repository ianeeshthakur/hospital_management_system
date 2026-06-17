package com.stickytechnologies.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private Integer gradePay;


    private String role;
    private Double salary;
    private Double houseRentAllowance;
    private Double dearnessAllowance;
    private Double transportAllowance;
    private Double medicalAllowance;
    private Double uniformAllowance;
    private Double nightShiftAllowance;
    private Double onCallAllowance;
    private Double riskAllowance;
    private Double performanceBonus;
    private Double overtimeAllowance;
    private Double seniorityAllowance;
    private Double taxDeduction;
    private Double providentFund;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
@OneToMany(mappedBy = "salary")
private List<Nurses> nurses;


@OneToOne(mappedBy = "salary")
    private Doctors doctors;
}
