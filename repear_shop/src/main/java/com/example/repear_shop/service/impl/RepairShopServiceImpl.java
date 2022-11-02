package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.RepairShop;
import com.example.repear_shop.data.repository.RepairShopRepository;
import com.example.repear_shop.service.RepairShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairShopServiceImpl implements RepairShopService {
    private final RepairShopRepository repository;

    public RepairShopServiceImpl(RepairShopRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RepairShop> getRepairShops() {
        return this.repository.findAll();
    }

    @Override
    public RepairShop createRepairShop(RepairShop repairShop) {
        return this.repository.save(repairShop);
    }

    @Override
    public RepairShop updateRepairShop(Long repairShopId, RepairShop repairShop) {
        repairShop.setRepairShopId(repairShopId);
        return this.repository.save(repairShop);
    }

    @Override
    public void deleteRepairShop(Long repairShopId) {
        this.repository.deleteById(repairShopId);
    }
}
