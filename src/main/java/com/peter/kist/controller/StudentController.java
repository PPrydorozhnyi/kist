package com.peter.kist.controller;

import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Student;
import com.peter.kist.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Integer id) {

        log.debug("getStudent");

        Student student = studentService.getStudent(id);

        model.addAttribute("studentForm", student);

        return "studentView";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {

        log.debug("createStudent");

        Student student = new Student();

        model.addAttribute("studentForm", student);

        return "studentCreation";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("studentForm") Student studentForm, BindingResult bindingResult) {

        log.debug("Student creation");

        studentService.createStudent(studentForm);

        return "redirect:/student/" + studentForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentForm") Student student, Model model) {
        log.debug("editStudent");

        return "studentCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteStudent");

        studentService.deleteStudent(id);

        return "redirect:/student/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllStudent");

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        model.addAttribute("deletedUserName", null);

        return "studentTableView";
    }

    @GetMapping("/{id}/groups")
    public String getGroupsForStudent(@PathVariable Integer id, Model model) {

        log.debug("getGroupsForStudent");

        List<Group> groupsForStudent = studentService.getGroupsForStudent(id);

        model.addAttribute("groups", groupsForStudent);

        return "groupTableView";
    }


}
