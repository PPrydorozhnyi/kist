package com.peter.kist.controller;

import com.peter.kist.model.entity.Mark;
import com.peter.kist.model.entity.Privilege;
import com.peter.kist.model.entity.Speciality;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.enums.MarkNames;
import com.peter.kist.service.MarkService;
import com.peter.kist.service.PrivilegeService;
import com.peter.kist.service.QueryService;
import com.peter.kist.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.*;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/queryY")
public class QueryYarikController {

    private static final String STUDENTS_PROPERTY_NAME = "students";

    private final QueryService queryService;

    private final PrivilegeService privilegeService;

    private final SpecialityService specialityService;

    private final MarkService markService;

    private final ModelMapper mapper;

    @GetMapping
    public String getQueryPage(Model model) {

        List<Privilege> privileges = privilegeService.findAll();
        List<Speciality> specialities = specialityService.findAll();
        List<Mark> marks = markService.findAll();

        final Map<String, Object> map = Map.of(
                "privileges", mapper.map(privileges, PRIVILEGE_LIST_TYPE),
                "specialities", mapper.map(specialities, SPECIALITY_LIST_TYPE),
                "marks", mapper.map(marks, MARK_LIST_TYPE)
        );

        model.addAllAttributes(map);

        return "query/queryY";
    }

    @GetMapping("/query1")
    public String getStudents(Model model, @RequestParam Integer privilegeId,
                              @RequestParam Date startDate, @RequestParam Date endDate) {

        log.debug("first query");

        final List<Student> students = queryService.queryY1(privilegeId, startDate, endDate);

        model.addAttribute(STUDENTS_PROPERTY_NAME, mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query2")
    public String getStudents(Model model, @RequestParam Date violationDate, @RequestParam Date orderDate) {

        log.debug("second query");

        final List<Student> students = queryService.queryY2(violationDate, orderDate);

        model.addAttribute(STUDENTS_PROPERTY_NAME, mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query3")
    public String getStudents(Model model, @RequestParam Integer specialityId, @RequestParam Integer markId) {

        log.debug("third query");

        final List<Student> students = queryService.queryY3(specialityId, markId);

        model.addAttribute(STUDENTS_PROPERTY_NAME, mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

}
