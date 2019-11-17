package com.peter.kist.controller;

import com.peter.kist.model.dto.SubjectDTO;
import com.peter.kist.model.entity.Subject;
import com.peter.kist.service.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController {

    private static final Type SUBJECT_DTO_LIST_TYPE = (new TypeToken<List<SubjectDTO>>() {
    }).getType();

    private final SubjectService subjectService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getSubject(Model model, @PathVariable Integer id) {

        log.debug("getSubject");

        Subject subject = subjectService.getSubject(id);

        model.addAttribute("subjectForm", mapper.map(subject, SubjectDTO.class));

        return "subjectView";
    }

    @GetMapping("/create")
    public String createSubject(Model model) {

        log.debug("createSubject");

        model.addAttribute("subjectForm", new SubjectDTO());

        return "subjectCreation";
    }

    @PostMapping("/create")
    public String createSubject(@ModelAttribute("subjectForm") SubjectDTO subjectForm, BindingResult bindingResult) {

        log.debug("Subject creation");

        Subject subject = mapper.map(subjectForm, Subject.class);

        subjectService.createSubject(subject);

        return "redirect:/subject/" + subject.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("subjectForm") SubjectDTO subject, Model model) {
        log.debug("editSubject");

        return "subjectCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteSubject");

        subjectService.deleteSubject(id);

        return "redirect:/subject/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllSubject");

        List<Subject> subjects = subjectService.findAll();

        model.addAttribute("subjects", mapper.map(subjects, SUBJECT_DTO_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "subjectTableView";
    }

}
