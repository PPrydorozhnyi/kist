package com.peter.kist.controller;

import com.peter.kist.model.dto.SemesterDTO;
import com.peter.kist.model.entity.Semester;
import com.peter.kist.service.SemesterService;
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
@RequestMapping("/semester")
public class SemesterController {

    private final SemesterService semesterService;

    private static final Type SEMESTER_LIST_TYPE = (new TypeToken<List<SemesterDTO>>() {
    }).getType();

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getSemester(Model model, @PathVariable Integer id) {

        log.debug("getSemester");

        Semester semester = semesterService.getSemester(id);

        model.addAttribute("semesterForm", mapper.map(semester, SemesterDTO.class));

        return "semesterView";
    }

    @GetMapping("/create")
    public String createSemester(Model model) {

        log.debug("createSemester");

        model.addAttribute("semesterForm", new SemesterDTO());

        return "semesterCreation";
    }

    @PostMapping("/create")
    public String createSemester(@ModelAttribute("semesterForm") SemesterDTO semesterForm, BindingResult bindingResult) {

        log.debug("Semester creation");

        Semester semester = mapper.map(semesterForm, Semester.class);

        if (bindingResult.hasErrors()) {
            return "semesterCreation";
        }

        semesterService.createSemester(semester);

        return "redirect:/semester/" + semester.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("semesterForm") SemesterDTO semester, Model model) {
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

        model.addAttribute("semesters", mapper.map(semesters, SEMESTER_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "semesterTableView";
    }


}
