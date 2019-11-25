package com.peter.kist.controller;

import com.peter.kist.model.entity.*;
import com.peter.kist.model.enums.MarkNames;
import com.peter.kist.service.*;
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
@RequestMapping("/queryP")
public class QueryController {

    private final QueryService queryService;

    private final GroupService groupService;

    private final SubjectService subjectService;

    private final PersonService personService;

    private final MarkService markService;

    private final ModelMapper mapper;

    @GetMapping
    public String getQueryPage(Model model) {

        List<Group> groups = groupService.findAll();
        List<Subject> subjects = subjectService.findAll();
        List<Person> persons = personService.getTeachers();
        List<Mark> marks = markService.findAll();

        final Map<String, Object> map = Map.of(
                "groups", mapper.map(groups, GROUP_LIST_TYPE),
                "subjects", mapper.map(subjects, SUBJECT_LIST_TYPE),
                "persons", mapper.map(persons, PERSON_LIST_TYPE),
                "marks", mapper.map(marks, MARK_LIST_TYPE)
        );

        model.addAllAttributes(map);

        return "query/queryP";
    }

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

    @GetMapping("/query3")
    public String getTeachers(Model model, @RequestParam Integer personId, @RequestParam MarkNames mark) {

        log.debug("third query");

        final List<Student> students = queryService.query3(personId, mark);

        model.addAttribute("students", mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

}
