package com.peter.kist.controller;

import com.peter.kist.model.entity.Subject;
import com.peter.kist.service.SubjectService;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public String getSubject(Model model, @PathVariable Integer id) {

        log.debug("getSubject");

        Subject subject = subjectService.getSubject(id);

        model.addAttribute("subjectForm", subject);

        return "subjectView";
    }

    @GetMapping("/create")
    public String createSubject(Model model) {

        log.debug("createSubject");

        Subject subject = new Subject();

        model.addAttribute("subjectForm", subject);

        return "subjectCreation";
    }

    @PostMapping("/create")
    public String createSubject(@ModelAttribute("subjectForm") Subject subjectForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Subject creation");

        if (bindingResult.hasErrors()) {
            return "subjectCreation";
        }

        subjectService.createSubject(subjectForm);

        return "redirect:/subject/" + subjectForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("subjectForm") Subject subject, Model model) {
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

        model.addAttribute("subjects", subjects);

        model.addAttribute("deletedUserName", null);

        return "subjectTableView";
    }

    /*@GetMapping("/{id}/groups")
    public String getGroupsForStudent(@PathVariable Integer id, Model model) {

        log.debug("getGroupsForStudent");

        List<Group> groupsForStudent = studentService.getGroupsForStudent(id);

        model.addAttribute("groups", groupsForStudent);

        return "groupTableView";
    }*/


}
