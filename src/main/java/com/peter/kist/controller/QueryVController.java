package com.peter.kist.controller;

import com.peter.kist.model.dto.ThirdQueryDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.entity.ViolationKind;
import com.peter.kist.service.GroupService;
import com.peter.kist.service.QueryService;
import com.peter.kist.service.ViolationKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.*;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/queryV")
public class QueryVController{

    private final QueryService queryService;

    private final ConversionService conversionService;

    private final GroupService groupService;

    private final ViolationKindService violationKindService;

    private final ModelMapper mapper;

    @GetMapping
    public String getQueryPage(Model model) {

        List<Group> groups = groupService.findAll();
        List<ViolationKind> violationKinds = violationKindService.findAll();

        final Map<String, Object> map = Map.of(
                "groups", mapper.map(groups, GROUP_LIST_TYPE),
                "violationKinds", mapper.map(violationKinds, VIOLATION_KIND_LIST_TYPE)
        );

        model.addAllAttributes(map);

        return "query/queryV";
    }

    @GetMapping("/query1")
    public String getStudents(Model model, @RequestParam Integer groupId) {

        log.debug("first V query");

        final List<Student> students = queryService.queryVadim1(groupId);

        model.addAttribute("students", mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query2")
    public String getTeachers(Model model, @RequestParam Integer violationKindId) {

        log.debug("second V query");

        final List<Student> students = queryService.queryVadim2(violationKindId);

        model.addAttribute("students", mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query3")
    public String getTeachers(Model model) {

        log.debug("third V query");

        final List<ThirdQueryDTO> queryEnd = (List<ThirdQueryDTO>) conversionService.convert(queryService.queryVadim3(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Student.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ThirdQueryDTO.class)));

        model.addAttribute("queryEnd", queryEnd);

        return "query/queryVThird";
    }
}
