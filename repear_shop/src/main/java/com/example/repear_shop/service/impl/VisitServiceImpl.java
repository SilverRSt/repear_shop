package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Visit;
import com.example.repear_shop.data.repository.VisitRepository;
import com.example.repear_shop.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepository repository;

    public VisitServiceImpl(VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Visit> getAllVisits() {
        return this.repository.findAll();
    }

    @Override
    public Visit createVisit(Visit visit) {
        return this.repository.save(visit);
    }

    @Override
    public Visit updateVisit(Long id, Visit visit) {
        visit.setVisitId(id);
        return this.repository.save(visit);
    }

    @Override
    public void deleteVisit(Long id) {
        this.repository.deleteById(id);
    }
}
