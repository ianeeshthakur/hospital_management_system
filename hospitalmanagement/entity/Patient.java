package com.stickytechnologies.hospitalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
//@Table(
//        uniqueConstraints={
//                @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"})
//        },
//        indexes = {
//                @Index(name = "idx_patient_birth_date",columnList = "birthDate")
//        }
//)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ToString.Exclude
    private LocalDate birthdate;
    private String email;
    private String gender;
    @Column(nullable = false,columnDefinition = "boolean default false")
    private boolean discharged;
@CreationTimestamp
@Column(updatable = false)
    private LocalDateTime createdat;

@OneToOne(mappedBy = "patient",cascade =CascadeType.ALL)
@JsonManagedReference
private Beds beds;

@OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
@JsonManagedReference
    private Doctors doctors;
}
