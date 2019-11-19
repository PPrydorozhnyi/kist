package com.peter.kist.controller;

import com.peter.kist.model.dto.SemesterDTO;
import com.peter.kist.model.entity.Semester;
import com.peter.kist.service.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.SEMESTER_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/semester")
public class SemesterController {

    private static final String SEMESTER_CREATION_PAGE = "semesterCreation";

    private final SemesterService semesterService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getSemester(Model model, @PathVariable Integer id) {

        log.debug("getSemester");

        Semester semester = semesterService.getSemester(id);

        model.addAttribute("semesterForm", mapper.map(semester, SemesterDTO.class));

        return "semester/semesterView";
    }

    @GetMapping("/create")
    public String createSemester(Model model) {

        log.debug("createSemester");

        model.addAttribute("semesterForm", new SemesterDTO());

        return SEMESTER_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createSemester(@ModelAttribute("semesterForm") SemesterDTO semesterForm, BindingResult bindingResult) {

        log.debug("Semester creation");

        Semester semester = mapper.map(semesterForm, Semester.class);

        if (bindingResult.hasErrors()) {
            return SEMESTER_CREATION_PAGE;
        }

        semesterService.createSemester(semester);

        return "redirect:/semester/" + semester.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("semesterForm") SemesterDTO semester, Model model) {
        log.debug("editSemester");

        return SEMESTER_CREATION_PAGE;
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

        return "semester/semesterTableView";
    }


}
