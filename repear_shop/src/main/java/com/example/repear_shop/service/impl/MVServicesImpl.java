package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.repository.MVRepository;
import com.example.repear_shop.service.MVService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MVServicesImpl implements MVService {
    private final MVRepository repository;

    public MVServicesImpl(MVRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MV> getMvs() {
        return this.repository.findAll();
    }

    @Override
    public MV createMV(MV mv) {
        return this.repository.save(mv);
    }

    @Override
    public MV updateMV(String vin, MV mv) {
        mv.setVin(vin);
        return this.repository.save(mv);
    }

    @Override
    public void deleteMV(String vin) {
        this.repository.deleteById(vin);
    }

    @Override
    public MV findByVin(String vin) {
        return this.repository.findOneByVin(vin);
    }
}
