package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.dto.QualificationDTO;
import com.example.repear_shop.service.QualificationService;
import com.example.repear_shop.web.view.model.qualification.QualificationUpdateViewModel;
import com.example.repear_shop.web.view.model.qualification.QualificationViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/qualifications")
public class QualificationViewController {
    private final QualificationService service;
    private final ModelMapper mapper;

    @GetMapping
    public String getQualifications(Model model) {
        final List<QualificationViewModel> qualifications = this.service.getQualifications()
                .stream()
                .sorted(Comparator.comparing(QualificationDTO::getQualification))
                .map(this::convertToQualificationViewModel)
                .collect(Collectors.toList());

        model.addAttribute("qualifications", qualifications);
        return "/qualifications/qualifications.html";
    }

    @GetMapping("/update-qualification/{id}")
    public String getQualification(@PathVariable Long id, Model model) {
        model.addAttribute("qualification", this.service.getQualificationById(id));
        return "/qualifications/update-qualification.html";
    }


    @GetMapping("/update/{id}")
    public String updateQualification(@PathVariable Long id, @Valid @ModelAttribute("qualification")QualificationUpdateViewModel qualification, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/qualifications/update-qualification.html";
        }

        this.service.updateQualification(id, this.mapper.map(qualification, QualificationDTO.class));
        return "redirect:/qualifications";
    }



    private QualificationViewModel convertToQualificationViewModel(QualificationDTO qualificationDTO) {
        return this.mapper.map(qualificationDTO, QualificationViewModel.class);
    }
}
