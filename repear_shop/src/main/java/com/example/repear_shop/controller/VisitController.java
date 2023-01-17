package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Visit;
import com.example.repear_shop.dto.VisitsCreateDTO;
import com.example.repear_shop.service.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {
    private final VisitService service;
    private final ModelMapper mapper;

    public VisitController(VisitService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Visit> getAllVisits() {
        return this.service.getAllVisits();
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return this.service.createVisit(this.mapper.map(visit, VisitsCreateDTO.class));
    }

    @PutMapping("/{id}")
    public Visit updateVisit(@PathVariable Long id,@RequestBody Visit visit) {
        return this.service.updateVisit(id, visit);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        this.service.deleteVisit(id);
    }

    @GetMapping("/client/{firstName} {lastName}")
    public List<Visit> getAllVisitsForClient(@PathVariable String firstName, @PathVariable String lastName) {
        return this.service.getAllVisitsForClient(firstName, lastName);
    }

    @GetMapping("/clientId/{id}")
    public List<Visit> getAllVisitsForClient(@PathVariable Long id) {
        return this.service.getAllVisitsForClient(id);
    }
}
