package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Brand;
import com.example.repear_shop.data.repository.BrandRepository;
import com.example.repear_shop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brand> getBrands() {
        return this.repository.findAll();
    }

    @Override
    public Brand createBrand(Brand brand) {
        return this.repository.save(brand);
    }

    @Override
    public Brand updateBrand(String brandName, Brand brand) {
        brand.setBrand(brandName);
        return this.repository.save(brand);
    }

    @Override
    public void deleteBrand(String brandName) {
        this.repository.deleteById(brandName);
    }
}
