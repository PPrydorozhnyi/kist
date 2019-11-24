package com.peter.kist.controller;

import com.peter.kist.model.dto.ThirdQueryDTO;
import com.peter.kist.model.entity.Student;
import com.peter.kist.service.QueryService;
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

import static com.peter.kist.AppConstants.STUDENT_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/queryV")
public class QueryVController{

    private final QueryService queryService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping
    public String getQueryPage() {
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

        model.addAttribute("studentsV2", mapper.map(students, STUDENT_LIST_TYPE));

        return "student/studentTableView";
    }

    @GetMapping("/query3")
    public String getTeachers(Model model) {

        log.debug("third V query");

        final List<ThirdQueryDTO> queryEnd = (List<ThirdQueryDTO>) conversionService.convert(queryService.queryVadim3(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Student.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ThirdQueryDTO.class)));

        model.addAttribute("queryEnd", queryEnd);

        return "student/studentTableView";
    }
}
