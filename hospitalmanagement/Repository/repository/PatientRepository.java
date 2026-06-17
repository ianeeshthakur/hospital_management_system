package com.stickytechnologies.hospitalmanagement.Repository.repository;


import com.stickytechnologies.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByname(String aneeshThakur);

    void delete(Patient found);
}
