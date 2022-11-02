package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.RepairShop;
import com.example.repear_shop.service.RepairShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairShop")
public class RepairShopController {
    private final RepairShopService service;

    public RepairShopController(RepairShopService service) {
        this.service = service;
    }

    @GetMapping
    public List<RepairShop> getRepairShops() {
        return this.service.getRepairShops();
    }

    @PostMapping
    public RepairShop createRepairShop(@RequestBody RepairShop repairShop) {
        return this.service.createRepairShop(repairShop);
    }

    @PutMapping("/{repairShopId}")
    public RepairShop updateRepairShop(@PathVariable Long repairShopId,@RequestBody RepairShop repairShop) {
        return this.service.updateRepairShop(repairShopId, repairShop);
    }

    @DeleteMapping("/{repairShopId}")
    public void deleteRepairShop(@PathVariable Long repairShopId) {
        this.service.deleteRepairShop(repairShopId);
    }
}
