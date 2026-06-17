package com.stickytechnologies.hospitalmanagement.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;

@Entity
@Getter
@Setter
public class Doctors {
    @Id

    private String id;

    private String doctorname;


    @ManyToOne

    @JoinColumn(name="department_id")
    private Department cardioDepartment;

    private boolean occupied;

@OneToOne
@JoinColumn(name="patient_id")

    private Patient patient;

@OneToOne
    @JoinColumn(name = "appointment_patient_id")
@JsonManagedReference
    private AppointmentPatients patints;

private String price;

private Integer floor;
private String room_no;

private String designation;

private String password;

private String doctor_image;

@OneToOne
    @JoinColumn(name = "grade_pay")
    private Salary salary;
}
