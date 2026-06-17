package com.stickytechnologies.hospitalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Beds {
    @Id
    private String id;
    private int bedno;

    @ManyToOne

    @JoinColumn(name = "hospitalid")

    private Hospital hospital;

    boolean occupied;
@OneToOne

@JoinColumn(name="patientid")

@JsonBackReference

    private Patient patient;


@ManyToOne
    @JoinColumn(name = "ward_id")
private Ward ward;
}
