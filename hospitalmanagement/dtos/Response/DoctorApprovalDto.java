package com.stickytechnologies.hospitalmanagement.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorApprovalDto {
    private String doctor_name;
    private String designation;
    private String message;
}
