package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.dto.QualificationDTO;
import com.example.repear_shop.service.QualificationService;
import com.example.repear_shop.web.view.model.qualification.QualificationCreateViewModel;
import com.example.repear_shop.web.view.model.qualification.QualificationUpdateViewModel;
import com.example.repear_shop.web.view.model.qualification.QualificationViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("create-qualification")
    public String showCreateQualificationForm(Model model) {
        model.addAttribute("qualification", new QualificationCreateViewModel());
        return "/qualifications/create-qualification.html";
    }

    @PostMapping("/create")
    public String createQualification(@Valid@ModelAttribute("qualification") QualificationCreateViewModel qualification, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/qualifications/create-qualification.html";
        }

        this.service.createQualification(this.mapper.map(qualification, QualificationDTO.class));
        return "redirect:/qualifications";
    }

    @GetMapping("/update-qualification/{id}")
    public String getQualification(@PathVariable Long id, Model model) {
        try {
            //model.addAttribute("qualification", this.service.getQualificationById(id));

            model.addAttribute("qualification", this.mapper.map(this.service.getQualificationById(id),
                    QualificationUpdateViewModel.class));

        } catch (Exception e) {
            throw new IllegalArgumentException("Not valid qualification id detected.");
        }

        return "/qualifications/update-qualification.html";
    }

    @PostMapping("/update/{id}")
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
