package com.example.repear_shop.service;


import com.example.repear_shop.data.entity.Qualification;

import java.util.List;

public interface QualificationService {
    List<Qualification> getQualifications();

    Qualification createQualification(Qualification qualification);

    Qualification updateQualification(Long id, Qualification qualification);

    void deleteQualification(Long id);
}
