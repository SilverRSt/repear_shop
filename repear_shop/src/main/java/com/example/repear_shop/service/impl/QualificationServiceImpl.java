package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Qualification;
import com.example.repear_shop.data.repository.QualificationRepository;
import com.example.repear_shop.dto.QualificationDTO;
import com.example.repear_shop.service.QualificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository repository;
    private final ModelMapper mapper;

    public QualificationServiceImpl(QualificationRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<QualificationDTO> getQualifications() {
        return this.repository.findAll()
                .stream()
                .map(this::convertToQualificationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Qualification createQualification(QualificationDTO qualification) {
        return this.repository.save(this.mapper.map(qualification, Qualification.class));
    }

    @Override
    public Qualification updateQualification(Long id, QualificationDTO qualification) {
        qualification.setQualificationId(id);
        return this.repository.save(this.mapper.map(qualification, Qualification.class));
    }

    @Override
    public void deleteQualification(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Qualification getQualificationById(Long id) {
        return this.repository.getReferenceById(id);
    }


    private QualificationDTO convertToQualificationDTO(Qualification qualification) {
        return this.mapper.map(qualification, QualificationDTO.class);
    }
}
