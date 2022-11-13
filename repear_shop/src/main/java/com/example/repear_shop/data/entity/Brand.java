package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Brand {
    @Id
    private String brand;

    @OneToMany(mappedBy = "brand")
    @JsonIgnoreProperties({"model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId"})
    private List<Model> modelList;

    @OneToMany(mappedBy = "brandRestriction")
    @JsonIgnoreProperties({"brandRestriction"})
    private List<RepairShop> repairShopList;

}
