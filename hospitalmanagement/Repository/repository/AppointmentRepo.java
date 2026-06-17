package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.AppointmentPatients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentPatients,Long> {
}
