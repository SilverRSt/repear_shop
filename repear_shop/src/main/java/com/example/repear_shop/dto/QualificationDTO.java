package com.example.repear_shop.dto;

import com.example.repear_shop.data.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QualificationDTO {
    private Long qualificationId;
    private String qualification;
    private List<Employee> employees;
}
