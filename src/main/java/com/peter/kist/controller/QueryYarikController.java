package com.peter.kist.controller;

import com.peter.kist.model.entity.Student;
import com.peter.kist.model.enums.MarkNames;
import com.peter.kist.service.QueryService;
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

import static com.peter.kist.AppConstants.STUDENT_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/queryY")
public class QueryYarikController {

    private static final String STUDENTS_PROPERTY_NAME = "students";

    private final QueryService queryService;

    private final ModelMapper mapper;

    @GetMapping
    public String getQueryPage(Model model) {

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

        return "person/personTableView";
    }

    @GetMapping("/query3")
    public String getStudents(Model model, @RequestParam Integer specialityId, @RequestParam MarkNames mark) {

        log.debug("third query");

        final List<Student> students = queryService.queryY3(specialityId, mark);

        model.addAttribute(STUDENTS_PROPERTY_NAME, mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

}
