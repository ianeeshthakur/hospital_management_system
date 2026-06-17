package com.stickytechnologies.hospitalmanagement.dtos.Response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDto {
    private int id;
    private String name;
    private String email;
    private String doctorName;
}
