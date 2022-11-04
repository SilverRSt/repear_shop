package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> getAllVisits();

    Visit createVisit(Visit visit);

    Visit updateVisit(Long id, Visit visit);

    void deleteVisit(Long id);
}
