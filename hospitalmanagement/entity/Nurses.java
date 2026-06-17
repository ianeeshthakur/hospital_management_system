package com.stickytechnologies.hospitalmanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Nurses {
    @Id
    private String id;

    private String name;

    private String gender;

    private String shift_session;


    private LocalDateTime dateTime;

    @ManyToOne

    @JoinColumn(name = "department_id")

    private Department department;

    @ManyToOne
    @JoinColumn(name = "salary")
     private Salary salary;

}
