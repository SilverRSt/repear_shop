package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Qualification;
import com.example.repear_shop.service.QualificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualifications")
public class QualificationController {
    private final QualificationService service;

    public QualificationController(QualificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Qualification> getQualifications(){
        return this.service.getQualifications();
    }

    @PostMapping
    public Qualification createQualification(@RequestBody Qualification qualification){
        return this.service.createQualification(qualification);
    }

    @PutMapping("/{id}")
    public Qualification updateQualification(@PathVariable Long id,@RequestBody Qualification qualification){
        return this.service.updateQualification(id, qualification);
    }

    @DeleteMapping("/{id}")
    public void deleteQualification(@PathVariable Long id){
        this.service.deleteQualification(id);
    }
}
