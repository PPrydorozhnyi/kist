package com.peter.kist.controller;

import com.peter.kist.model.dto.SubjectDTO;
import com.peter.kist.model.entity.Subject;
import com.peter.kist.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.SUBJECT_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getSubject(Model model, @PathVariable Integer id) {

        log.debug("getSubject");

        Subject subject = subjectService.getSubject(id);

        model.addAttribute("subjectForm", mapper.map(subject, SubjectDTO.class));

        return "subject/subjectView";
    }

    @GetMapping("/create")
    public String createSubject(Model model) {

        log.debug("createSubject");

        model.addAttribute("subjectForm", new SubjectDTO());

        return "subject/subjectCreation";
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

        return "subject/subjectCreation";
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

        model.addAttribute("subjects", mapper.map(subjects, SUBJECT_LIST_TYPE));

        return "subject/subjectTableView";
    }

}
