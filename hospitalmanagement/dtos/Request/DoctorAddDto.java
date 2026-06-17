package com.stickytechnologies.hospitalmanagement.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAddDto {
    private String doctor_name;
    private String designation;
private String department;
}
