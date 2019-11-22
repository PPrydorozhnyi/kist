package com.peter.kist.controller;

import com.peter.kist.model.dto.PersonPrivilegeDTO;
import com.peter.kist.model.dto.PrivilegeDTO;
import com.peter.kist.model.dto.PersonShortDTO;
import com.peter.kist.model.entity.PersonPrivilege;
import com.peter.kist.model.entity.Privilege;
import com.peter.kist.model.entity.Person;
import com.peter.kist.service.PrivilegeService;
import com.peter.kist.service.PersonPrivilegeService;
import com.peter.kist.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.*;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/person-privilege")
public class PersonPrivilegeController {

    private static final String PERSON_PRIVILEGE_CREATION_PAGE = "person-privilege/personPrivilegeCreation";

    private final PersonPrivilegeService personPrivilegeService;

    private final PersonService personService;

    private final PrivilegeService privilegeService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/person/{personId}/privilege/{privilegeId}")
    public String getPersonPrivilege(Model model, @PathVariable Integer personId, @PathVariable Integer privilegeId) {

        log.debug("getPersonPrivilege");

        PersonPrivilege personPrivilege = personPrivilegeService.getPersonPrivilege(personId, privilegeId);

        model.addAttribute("personPrivilegeForm", mapper.map(personPrivilege, PersonPrivilegeDTO.class));

        return "person-privilege/personPrivilegeVie";
    }

    @GetMapping("/create")
    public String createPersonPrivilege(Model model) {

        log.debug("createPersonPrivilege");

        List<Person> persons = personService.findAll();

        List<Privilege> privileges = privilegeService.findAll();

        final Map<String, Object> map = Map.of("personPrivilegeForm", new PersonPrivilegeDTO(new PersonShortDTO(), new PrivilegeDTO()),
                "persons", mapper.map(persons, PERSON_SHORT_LIST_TYPE),
                "privileges", mapper.map(privileges, PRIVILEGE_LIST_TYPE));

        model.addAllAttributes(map);

        return PERSON_PRIVILEGE_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createPersonPrivilege(@ModelAttribute("personPrivilegeForm") PersonPrivilegeDTO personPrivilegeForm, BindingResult bindingResult) {

        log.debug("PersonPrivilege creation");

        PersonPrivilege personPrivilege = conversionService.convert(personPrivilegeForm, PersonPrivilege.class);

        if (bindingResult.hasErrors()) {
            return PERSON_PRIVILEGE_CREATION_PAGE;
        }

        personPrivilege = personPrivilegeService.createPersonPrivilege(personPrivilege);

        return "redirect:/person-privilege/person/" + personPrivilege.getPerson().getId() + "/privilege/" + personPrivilege.getPrivilege().getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("personPrivilegeForm") PersonPrivilegeDTO personPrivilege, Model model) {
        log.debug("editPersonPrivilege");

        List<Person> persons = personService.findAll();

        List<Privilege> privileges = privilegeService.findAll();

        final Map<String, Object> map = Map.of("persons", mapper.map(persons, PERSON_SHORT_LIST_TYPE),
                "privileges", mapper.map(privileges, PRIVILEGE_LIST_TYPE));

        model.addAllAttributes(map);

        return PERSON_PRIVILEGE_CREATION_PAGE;
    }

    @DeleteMapping("/person/{personId}/privilege/{privilegeId}")
    public String delete(@PathVariable Integer personId, @PathVariable Integer privilegeId) {

        log.debug("deletePersonPrivilege");

        personPrivilegeService.deletePersonPrivilege(personId, privilegeId);

        return "redirect:/person-privilege/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllPersonPrivilege");

        List<PersonPrivilege> personPrivileges = personPrivilegeService.findAll();

        model.addAttribute("personPrivileges", mapper.map(personPrivileges, PERSON_PRIVILEGE_LIST_TYPE));

        return "person-privilege/personPrivilegeTableView";
    }

}
