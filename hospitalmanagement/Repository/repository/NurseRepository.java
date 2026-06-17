package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.Nurses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurses,String> {


    Integer countByDepartmentId(long l);
}
