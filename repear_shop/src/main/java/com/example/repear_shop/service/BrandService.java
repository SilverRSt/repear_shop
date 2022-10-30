package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrands();
    Brand createBrand(Brand brand);
    Brand updateBrand(String brandName, Brand brand);
    void deleteBrand(String brandName);
}
