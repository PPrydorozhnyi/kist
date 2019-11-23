package com.peter.kist.controller;

import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.Student;
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

import static com.peter.kist.AppConstants.PERSON_LIST_TYPE;
import static com.peter.kist.AppConstants.STUDENT_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/query")
public class QueryController {

    private final QueryService queryService;

    private final ModelMapper mapper;

    @GetMapping("/query1")
    public String getStudents(Model model, @RequestParam Integer groupId) {

        log.debug("first query");

        final List<Student> students = queryService.query1(groupId);

        model.addAttribute("students", mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query2")
    public String getTeachers(Model model, @RequestParam Date startDate, @RequestParam Date endDate,
                              @RequestParam Integer subjectId) {

        log.debug("second query");

        final List<Person> people = queryService.query2(startDate, endDate, subjectId);

        model.addAttribute("person", mapper.map(people, PERSON_LIST_TYPE));

        return "person/personTableView";
    }


}
