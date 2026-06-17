package com.stickytechnologies.hospitalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AppointmentPatients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate birthdate;
    private String email;
    private String gender;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdat;
private Double budget;
    private String disease;

    @OneToOne(mappedBy = "patints",cascade = CascadeType.ALL)
    @JsonBackReference
    @PrimaryKeyJoinColumn(name="doctor")
    private  Doctors doctors;




}
