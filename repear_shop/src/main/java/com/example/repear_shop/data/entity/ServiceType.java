package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @NotBlank
    private String service;

    @NotBlank
    private Double price;

    @ManyToMany
    @JsonIgnoreProperties({"mvList", "mvList", "visits", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<RepairShop> repairShops;

    @ManyToMany
    @JoinTable(name = "visit_services",
        joinColumns = @JoinColumn(name = "service_id"),
        inverseJoinColumns = @JoinColumn(name = "visit_id"))
    @JsonIgnoreProperties({"mvList", "mvList", "visits", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<Visit> visits;

    public List<Visit> getVisits() {
        if(this.visits == null) {
            this.visits = new ArrayList<>();
        }

        return visits;
    }
}
