package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    private String model;

    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    @JsonIgnoreProperties({"mvList", "visits", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "vin"})
    private List<MV> mvList;

    public Model(String model) {
        this.model = model;
    }
}
