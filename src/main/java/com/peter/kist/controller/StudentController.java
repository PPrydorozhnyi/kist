package com.peter.kist.controller;

import com.peter.kist.model.Student;
import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Integer id) {

        logger.debug("student");

        Student student = studentService.getStudent(id);

        model.addAttribute("studentForm", student);

        return "studentView";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {

        Student student = new Student();

        model.addAttribute("studentForm", student);

        return "studentCreation";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("studentForm") Student studentForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Student creation");

        if (bindingResult.hasErrors()) {
            return "studentCreation";
        }

        studentService.createStudent(studentForm);

        return "redirect:/student/" + studentForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentForm") Student student, Model model) {

        return "studentCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return "redirect:/student/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        model.addAttribute("deletedUserName", null);

        return "studentTableView";
    }


}
