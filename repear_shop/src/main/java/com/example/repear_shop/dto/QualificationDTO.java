package com.example.repear_shop.dto;

import com.example.repear_shop.data.entity.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QualificationDTO {
    private Long qualificationId;
    private String qualification;
    private List<Employee> employees;
}
