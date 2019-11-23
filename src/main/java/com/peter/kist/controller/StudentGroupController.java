package com.peter.kist.controller;

import com.peter.kist.model.dto.GroupDTO;
import com.peter.kist.model.dto.PersonShortDTO;
import com.peter.kist.model.dto.StudentGroupDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.entity.StudentGroup;
import com.peter.kist.service.GroupService;
import com.peter.kist.service.StudentGroupService;
import com.peter.kist.service.StudentService;
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
@RequestMapping("/student-group")
public class StudentGroupController {

    private static final String STUDENT_GROUP_CREATION_PAGE = "student-group/studentGroupCreation";

    private final StudentGroupService studentGroupService;

    private final StudentService studentService;

    private final GroupService groupService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/student/{studentId}/group/{groupId}")
    public String getStudentGroup(Model model, @PathVariable Integer studentId, @PathVariable Integer groupId) {

        log.debug("getStudentGroup");

        StudentGroup studentGroup = studentGroupService.getStudentGroup(studentId, groupId);

        model.addAttribute("studentGroupForm", mapper.map(studentGroup, StudentGroupDTO.class));

        return "student-group/studentGroupView";
    }

    @GetMapping("/create")
    public String createStudentGroup(Model model) {

        log.debug("createStudentGroup");

        List<Student> students = studentService.findAll();

        List<Group> groups = groupService.findAll();

        final Map<String, Object> map = Map.of("studentGroupForm", new StudentGroupDTO(new PersonShortDTO(), new GroupDTO()),
                "students", mapper.map(students, PERSON_SHORT_LIST_TYPE),
                "groups", mapper.map(groups, GROUP_LIST_TYPE));

        model.addAllAttributes(map);

        return STUDENT_GROUP_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createStudentGroup(@ModelAttribute("studentGroupForm") StudentGroupDTO studentGroupForm, BindingResult bindingResult) {

        log.debug("StudentGroup creation");

        StudentGroup studentGroup = conversionService.convert(studentGroupForm, StudentGroup.class);

        if (bindingResult.hasErrors()) {
            return STUDENT_GROUP_CREATION_PAGE;
        }

        studentGroup = studentGroupService.createStudentGroup(studentGroup);

        return "redirect:/student-group/student/" + studentGroup.getStudent().getId() + "/group/" + studentGroup.getGroup().getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentGroupForm") StudentGroupDTO studentGroup, Model model) {
        log.debug("editStudentGroup");

        List<Student> students = studentService.findAll();

        List<Group> groups = groupService.findAll();

        final Map<String, Object> map = Map.of("students", mapper.map(students, PERSON_SHORT_LIST_TYPE),
                "groups", mapper.map(groups, GROUP_LIST_TYPE));

        model.addAllAttributes(map);

        return STUDENT_GROUP_CREATION_PAGE;
    }

    @DeleteMapping("/student/{studentId}/group/{groupId}")
    public String delete(@PathVariable Integer studentId, @PathVariable Integer groupId) {

        log.debug("deleteStudentGroup");

        studentGroupService.deleteStudentGroup(studentId, groupId);

        return "redirect:/student-group/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllStudentGroup");

        List<StudentGroup> studentGroups = studentGroupService.findAll();

        model.addAttribute("studentGroups", mapper.map(studentGroups, STUDENT_GROUP_LIST_TYPE));

        return "student-group/studentGroupTableView";
    }
}
