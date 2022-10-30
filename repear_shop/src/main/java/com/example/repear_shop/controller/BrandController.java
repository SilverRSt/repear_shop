package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Brand;
import com.example.repear_shop.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public List<Brand> getBrands(){
        return this.service.getBrands();
    }

    @PostMapping
    public Brand createBrand(Brand brand){
        return this.service.createBrand(brand);
    }

    @PutMapping("/{brandName}")
    public Brand updateBrand(String brandName, Brand brand){
        return this.service.updateBrand(brandName, brand);
    }

    @DeleteMapping("/{brandName}")
    public void deleteBrand(String brandName){
        this.service.deleteBrand(brandName);
    }
}
