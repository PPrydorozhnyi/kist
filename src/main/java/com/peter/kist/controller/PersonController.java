package com.peter.kist.controller;

import com.peter.kist.model.dto.PersonDTO;
import com.peter.kist.model.entity.Person;
import com.peter.kist.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/person")

public class PersonController {

    private static final Type PERSON_LIST_TYPE = (new TypeToken<List<PersonDTO>>() {
    }).getType();

    private final PersonService personService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getPerson(Model model, @PathVariable Integer id) {

        log.debug("getPerson");

        Person person = personService.getPerson(id);

        model.addAttribute("personForm", mapper.map(person, PersonDTO.class));

        return "personView";
    }

    @GetMapping("/create")
    public String createPerson(Model model) {

        log.debug("createPerson");

        model.addAttribute("personForm", new PersonDTO());

        return "personCreation";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute("personForm") PersonDTO personForm, BindingResult bindingResult) {

        log.debug("Person creation");

        Person person = mapper.map(personForm, Person.class);

        person = personService.createPerson(person);

        return "redirect:/person/" + person.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("personForm") PersonDTO person, Model model) {
        log.debug("editPerson");

        return "personCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deletePerson");

        personService.deletePerson(id);

        return "redirect:/person/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllPerson");

        List<Person> persons = personService.findAll();

        model.addAttribute("person", mapper.map(persons, PERSON_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "personTableView";
    }

}
