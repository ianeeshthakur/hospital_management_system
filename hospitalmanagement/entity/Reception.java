package com.stickytechnologies.hospitalmanagement.entity;
@Entity
  @Getter
  @Setter
public class Reception{
  @Id
  private String patient_id;

  private String patient_name;
  private String patient_address;
  private String patient_gender;
  private String patient_mobileno;
  private String patient_disease;

  @OneToMany(mappedBy="patient")
  @JsonManagedReference
  private List<Doctors> doctor;
}
