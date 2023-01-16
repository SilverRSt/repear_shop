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
public class RepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_shop_id", nullable = false)
    private Long repairShopId;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "repairShopId")
    @JsonIgnoreProperties({"visits", "users", "roles", "userId", "roleId", "model", "repairShopId", "employeeId", "clientId", "qualificationId", "visitId", "person", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<Employee> employeeList;

    @ManyToOne
    @JoinColumn(name = "brand_restriction")
    private Brand brandRestriction;

    @ManyToMany(mappedBy = "repairShops")
    @JsonIgnoreProperties({"visits", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<ServiceType> services;

    public RepairShop(Long repairShopId) {
        this.repairShopId = repairShopId;
    }

}
