package com.example.repear_shop.web.view.model.visits;

import com.example.repear_shop.data.entity.Employee;
import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.ServiceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VisitsViewModel {
    private Long visitId;

    @NotBlank
    private MV clientId;

    @NotBlank
    private Employee employeeId;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotBlank
    private Double price;

    @NotBlank
    private List<ServiceType> services;

}
