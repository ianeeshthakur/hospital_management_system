package com.stickytechnologies.hospitalmanagement.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private int id;
    private String name;
    private String email;
    private int bedNo;
}
