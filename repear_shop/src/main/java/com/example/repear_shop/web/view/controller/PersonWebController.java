//package com.example.repear_shop.web.view.controller;
//
//import com.example.repear_shop.data.entity.Person;
//import com.example.repear_shop.dto.PersonDTO;
//import com.example.repear_shop.service.PersonService;
//import com.example.repear_shop.web.view.model.PersonViewModel;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@AllArgsConstructor
//@RequestMapping("/api/persons")
//public class PersonWebController {
//    private final PersonService service;
//
//    private final ModelMapper mapper;
//
//    public String getPersons(Model model) {
//        final List<Person> persons = this.service.getPersons()
//                .stream()
//                .map(x -> convertToPersonViewModel(x))
//                .collect(Collectors.toList());
//
//        model.addAttribute("persons", persons);
//        return "/person/persons";
//    }
//
//    private PersonViewModel convertToPersonViewModel(PersonDTO personDTO) {
//        return this.mapper.map(personDTO, PersonViewModel.class);
//    }
//}
