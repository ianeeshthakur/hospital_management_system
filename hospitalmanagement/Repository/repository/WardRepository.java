package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward,String> {
}
