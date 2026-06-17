package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctors, UUID> {



    Doctors findFirstByOccupiedFalseAndCardioDepartmentName(String name);





    Integer countBycardioDepartmentId(long l);

    Doctors findByPasswordAndId(String password, String id);
}
