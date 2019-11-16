package com.peter.kist.controller;

import com.peter.kist.model.Person;
import com.peter.kist.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
@RequestMapping("/person")

public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public String getPerson(Model model, @PathVariable Integer id) {

        log.debug("getPerson");

        Person person = personService.getPerson(id);

        model.addAttribute("personForm", person);

        return "personView";
    }

    @GetMapping("/create")
    public String createPerson(Model model) {

        log.debug("createPerson");

        Person person = new Person();

        model.addAttribute("personForm", person);

        return "personCreation";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute("personForm") Person personForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Person creation");

        if (bindingResult.hasErrors()) {
            return "personCreation";
        }

        personService.createPerson(personForm);

        return "redirect:/person/" + personForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("personForm") Person person, Model model) {
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

        List<Person> person = personService.findAll();

        model.addAttribute("person", person);

        model.addAttribute("deletedUserName", null);

        return "personTableView";
    }

}
