package com.peter.kist.controller;

import com.peter.kist.model.dto.StudentDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Student;
import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.GROUP_LIST_TYPE;
import static com.peter.kist.AppConstants.STUDENT_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Integer id) {

        log.debug("getStudent");

        Student student = studentService.getStudent(id);

        model.addAttribute("studentForm", mapper.map(student, StudentDTO.class));

        return "studentView";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {

        log.debug("createStudent");

        model.addAttribute("studentForm", new StudentDTO());

        return "studentCreation";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("studentForm") StudentDTO studentForm, BindingResult bindingResult) {

        log.debug("Student creation");

        Student student = mapper.map(studentForm, Student.class);

        student = studentService.createStudent(student);

        return "redirect:/student/" + student.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentForm") StudentDTO student, Model model) {
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

        model.addAttribute("students", mapper.map(students, STUDENT_LIST_TYPE));

        return "studentTableView";
    }

    @GetMapping("/{id}/groups")
    public String getGroupsForStudent(@PathVariable Integer id, Model model) {

        log.debug("getGroupsForStudent");

        List<Group> groupsForStudent = studentService.getGroupsForStudent(id);

        model.addAttribute("groups", mapper.map(groupsForStudent, GROUP_LIST_TYPE));

        return "groupTableView";
    }


}
