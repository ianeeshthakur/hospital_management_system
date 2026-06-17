package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
