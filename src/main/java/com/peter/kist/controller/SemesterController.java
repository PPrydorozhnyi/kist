package com.peter.kist.controller;

import com.peter.kist.model.entity.Semester;
import com.peter.kist.service.SemesterService;
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
@RequestMapping("/semester")
public class SemesterController {

    private final SemesterService semesterService;

    @GetMapping("/{id}")
    public String getSemester(Model model, @PathVariable Integer id) {

        log.debug("getSemester");

        Semester semester = semesterService.getSemester(id);

        model.addAttribute("semesterForm", semester);

        return "semesterView";
    }

    @GetMapping("/create")
    public String createSemester(Model model) {

        log.debug("createSemester");

        Semester semester = new Semester();

        model.addAttribute("semesterForm", semester);

        return "semesterCreation";
    }

    @PostMapping("/create")
    public String createSemester(@ModelAttribute("semesterForm") Semester semesterForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Semester creation");

        if (bindingResult.hasErrors()) {
            return "semesterCreation";
        }

        semesterService.createSemester(semesterForm);

        return "redirect:/semester/" + semesterForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("semesterForm") Semester semester, Model model) {
        log.debug("editSemester");

        return "semesterCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteSemester");

        semesterService.deleteSemester(id);

        return "redirect:/semester/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllSemester");

        List<Semester> semesters = semesterService.findAll();

        model.addAttribute("semesters", semesters);

        model.addAttribute("deletedUserName", null);

        return "semesterTableView";
    }


}
