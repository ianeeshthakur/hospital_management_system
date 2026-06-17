package com.stickytechnologies.hospitalmanagement.Repository.repository;

import com.stickytechnologies.hospitalmanagement.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {

    Salary findByRole(String s);
}
