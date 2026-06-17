package com.stickytechnologies.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private int totalbeds;
    @OneToMany(mappedBy="hospital")  //ye jo hospital hai wo db ka koi table nahi balki beds wali class ka ek field hai

    private List<Beds> bed;
}
