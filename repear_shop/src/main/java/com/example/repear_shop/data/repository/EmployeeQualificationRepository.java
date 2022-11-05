package com.example.repear_shop.data.repository;

import com.example.repear_shop.data.compositionKeys.EmployeeQualificationKey;
import com.example.repear_shop.data.entity.EmployeeQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeQualificationRepository extends JpaRepository<EmployeeQualification,EmployeeQualificationKey> {

}
