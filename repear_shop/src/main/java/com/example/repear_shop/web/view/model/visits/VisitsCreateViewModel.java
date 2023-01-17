package com.example.repear_shop.web.view.model.visits;

import com.example.repear_shop.data.entity.Employee;
import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.ServiceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VisitsCreateViewModel {
    private Long visitId;

    @NotNull
    private MV clientId;

    @NotNull
    private Employee employeeId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private List<ServiceType> services;
}
