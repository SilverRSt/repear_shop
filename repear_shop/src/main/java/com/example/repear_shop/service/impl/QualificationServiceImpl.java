package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Qualification;
import com.example.repear_shop.data.repository.QualificationRepository;
import com.example.repear_shop.service.QualificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository repository;

    public QualificationServiceImpl(QualificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Qualification> getQualifications() {
        return this.repository.findAll();
    }

    @Override
    public Qualification createQualification(Qualification qualification) {
        return this.repository.save(qualification);
    }

    @Override
    public Qualification updateQualification(Long id, Qualification qualification) {
        qualification.setQualificationId(id);
        return this.repository.save(qualification);
    }

    @Override
    public void deleteQualification(Long id) {
        this.repository.deleteById(id);
    }
}
