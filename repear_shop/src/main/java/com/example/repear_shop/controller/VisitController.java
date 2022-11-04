package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Visit;
import com.example.repear_shop.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {
    private final VisitService service;

    public VisitController(VisitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Visit> getAllVisits() {
        return this.service.getAllVisits();
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return this.service.createVisit(visit);
    }

    @PutMapping("/{id}")
    public Visit updateVisit(@PathVariable Long id,@RequestBody Visit visit) {
        return this.service.updateVisit(id, visit);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        this.service.deleteVisit(id);
    }
}
