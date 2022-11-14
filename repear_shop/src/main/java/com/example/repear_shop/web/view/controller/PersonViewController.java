package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.dto.PersonCreateDTO;
import com.example.repear_shop.dto.PersonDTO;
import com.example.repear_shop.dto.PersonUpdateDTO;
import com.example.repear_shop.service.PersonService;
import com.example.repear_shop.web.view.model.PersonCreateViewModel;
import com.example.repear_shop.web.view.model.PersonUpdateViewModel;
import com.example.repear_shop.web.view.model.PersonViewModel;
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
@RequestMapping("/persons")
public class PersonViewController {
    private static final String MAIN_PAGE = "redirect:/persons";

    private final PersonService service;
    private final ModelMapper mapper;

    @GetMapping
    public String getPersons(Model model) {
        final List<PersonViewModel> persons = this.service.getPersons()
                .stream()
                .sorted(Comparator.comparing(PersonDTO::getFirstName))
                .map(this::convertToPersonViewModel)
                .collect(Collectors.toList());

        model.addAttribute("persons", persons);
        return "/persons/persons.html";
    }

    @GetMapping("/create-person")
    public String showCreatePersonForm(Model model) {
        model.addAttribute("person", new PersonCreateViewModel());
        return "/persons/create-person.html";
    }

    @PostMapping("/create")
    public String createPerson(@Valid @ModelAttribute("person") PersonCreateViewModel person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/persons/create-person.html";
        }

        this.service.createPerson(this.mapper.map(person, PersonCreateDTO.class));
        return "redirect:/persons";
    }

    @GetMapping("/update-person/{id}")
    public String getPerson(Model model, @PathVariable Long id) {
        //not working ?
    //    model.addAttribute("person", this.mapper.map(this.service.getPersonById(id),
    //            PersonUpdateViewModel.class));
        model.addAttribute("person", this.service.getPersonById(id));
        return "/persons/update-person.html";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, @Valid @ModelAttribute("person")PersonUpdateViewModel viewModel,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/persons/update-person.html";
        }

        this.service.updatePerson(id, this.mapper.map(viewModel, PersonUpdateDTO.class));
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        this.service.deletePerson(id);
        return "redirect:/persons";
    }




    private PersonViewModel convertToPersonViewModel(PersonDTO personDTO) {
        return this.mapper.map(personDTO, PersonViewModel.class);
    }
}
