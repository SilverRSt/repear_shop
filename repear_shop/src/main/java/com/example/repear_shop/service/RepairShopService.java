package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.RepairShop;

import java.util.List;

public interface RepairShopService {
    List<RepairShop> getRepairShops();

    RepairShop createRepairShop(RepairShop repairShop);

    RepairShop updateRepairShop(Long repairShopId, RepairShop repairShop);

    void deleteRepairShop(Long repairShopId);
}
