package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qualificationId;

    @NotBlank
    private String qualification;

    @ManyToMany
    @JsonIgnoreProperties({"visits", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "qualifications", "employee_id", "vin"})
    private List<Employee> employees;

}
