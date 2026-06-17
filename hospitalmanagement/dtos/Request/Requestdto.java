package com.stickytechnologies.hospitalmanagement.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requestdto {
    private String name;
    private String email;
    private String gender;
    private String disease;
    private Double budget;
    private LocalDate birthdate;
}
