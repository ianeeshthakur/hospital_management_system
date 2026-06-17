package com.stickytechnologies.hospitalmanagement.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private String doctorname;
    private String designation;
    private String doctor_image;
    private String id;
    private String message;

}
