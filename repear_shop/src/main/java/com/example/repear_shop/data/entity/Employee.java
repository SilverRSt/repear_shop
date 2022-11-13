package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends Person {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShopId;

    @OneToMany(mappedBy = "employeeId")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId", "qualificationId", "visitId", "clientId", "visits", "services", "repairShops", "serviceId", "qualifications", "repairShopId", "employee_id"})
    private List<Visit> visitList;

    @ManyToMany(mappedBy = "employees") //name of list from qualification
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "qualifications", "employee_id"})
    private List<Qualification> qualifications;

}

