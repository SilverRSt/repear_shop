package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Qualification;
import com.example.repear_shop.dto.QualificationDTO;
import com.example.repear_shop.service.QualificationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qualifications")
public class QualificationController {
    private final QualificationService service;
    private final ModelMapper mapper;

    public QualificationController(QualificationService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping
    public List<QualificationDTO> getQualifications(){
        return this.service.getQualifications();
    }

    @PostMapping
    public Qualification createQualification(@RequestBody Qualification qualification){
        return this.service.createQualification(this.mapper.map(qualification, QualificationDTO.class));
    }

    @PutMapping("/{id}")
    public Qualification updateQualification(@PathVariable Long id,@RequestBody Qualification qualification){
        return this.service.updateQualification(id, this.mapper.map(qualification, QualificationDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteQualification(@PathVariable Long id){
        this.service.deleteQualification(id);
    }
}
