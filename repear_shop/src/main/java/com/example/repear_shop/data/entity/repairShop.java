package com.example.repear_shop.data.entity;

import javax.persistence.*;

@Entity
public class repairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_shop_id", nullable = false)
    private Long repairShopId;

    private String name;

    private String address;

    //private Brand brandRestriction;

    public Long getRepairShopId() {
        return repairShopId;
    }

    public void setRepairShopId(Long repairShopId) {
        this.repairShopId = repairShopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
