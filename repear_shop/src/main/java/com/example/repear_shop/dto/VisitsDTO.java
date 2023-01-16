package com.example.repear_shop.dto;

import com.example.repear_shop.data.entity.Employee;
import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VisitsDTO {
    private Long visitsId;
    private MV clientId;
    private Employee employeeId;
    private LocalDate date;
    private Double price;
    private List<ServiceType> services;
}
