package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.MV;

import java.util.List;

public interface MVService {
    List<MV> getMvs();
    MV createMV(MV mv);
    MV updateMV(String vin, MV mv);
    void deleteMV(String vin);
}
