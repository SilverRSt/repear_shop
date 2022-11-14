package com.example.repear_shop.service;


import com.example.repear_shop.data.entity.Qualification;
import com.example.repear_shop.dto.QualificationDTO;

import java.util.List;

public interface QualificationService {
    List<QualificationDTO> getQualifications();

    Qualification createQualification(QualificationDTO qualification);

    Qualification updateQualification(Long id, QualificationDTO qualification);

    void deleteQualification(Long id);

    Qualification getQualificationById(Long id);
}
