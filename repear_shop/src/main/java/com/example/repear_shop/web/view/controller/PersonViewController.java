package com.example.repear_shop.web.view.controller;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.data.entity.Person;
import com.example.repear_shop.dto.PersonCreateDTO;
import com.example.repear_shop.dto.PersonDTO;
import com.example.repear_shop.dto.PersonUpdateDTO;
import com.example.repear_shop.service.MVService;
import com.example.repear_shop.service.PersonService;
import com.example.repear_shop.web.view.model.PersonCreateViewModel;
import com.example.repear_shop.web.view.model.PersonUpdateViewModel;
import com.example.repear_shop.web.view.model.PersonViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonViewController {
    private static final String MAIN_PAGE = "redirect:/persons";

    private final PersonService service;
    private final MVService mvService;
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

    @GetMapping("/pagination/page/{page}/size/{size}")
    public String getPersonsPagination(Model model, @PathVariable int page, @PathVariable int size) {
        Type pageType = new TypeToken<Page<PersonViewModel>>() {}.getType();

        final Page<PersonViewModel> pageOfPersons =
                this.mapper.map(this.service.getPersonsPagination(PageRequest.of(page-1, size)), pageType);

        model.addAttribute("pageOfPersons", pageOfPersons);
        int totalPages = pageOfPersons.getTotalPages();

        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "/persons/persons-pagination.html";
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
        try{
            model.addAttribute("person", this.mapper.map(this.service.getPersonById(id),
                    PersonUpdateViewModel.class));
        } catch (Exception e) {
            throw new IllegalArgumentException("Not valid person id detected.");
        }

        //model.addAttribute("person", this.service.getPersonById(id));
        model.addAttribute("mvs", this.service.getAllMvsNotBelongingToPerson(id)); //similar to getPersons()
        return "/persons/update-person.html";
    }

    @PostMapping("/addMV/{id}")
    public String addMV(Model model, @PathVariable Long id, @RequestParam String mvVin) {
        MV newMv = this.mvService.findByVin(mvVin);
        Person newPerson = this.service.getPersonById(id);
        newMv.setPerson(newPerson);

        this.mvService.updateMV(mvVin, newMv);
        model.addAttribute("person", newPerson);
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
