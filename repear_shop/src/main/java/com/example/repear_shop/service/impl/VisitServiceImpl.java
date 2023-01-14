package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Visit;
import com.example.repear_shop.data.repository.VisitRepository;
import com.example.repear_shop.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public List<Visit> getAllVisitsForClient(String firsName, String lastName) {
        List<Visit> allVisits = this.repository.findAll();

        return allVisits.stream().filter(v ->
                v.getClientId().getPerson().getFirstName().equals(firsName) &&
                v.getClientId().getPerson().getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<Visit> getAllVisitsForClient(Long id) {
        List<Visit> allVisits = this.repository.findAll();

        return allVisits.stream().filter(v-> Objects.equals(v.getClientId().getPerson().getUserId(), id)).collect(Collectors.toList());
    }
}
