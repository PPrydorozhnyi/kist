package com.peter.kist.controller;

import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor_={@Autowired})
@RequestMapping("/query")
public class QueryController {

    private final StudentService studentService;

    @GetMapping("/query1")
    public String getStudent(Model model, @PathVariable Integer id) {

        log.debug("first query");

//        Student student = studentService.getStudent(id);
//
//        model.addAttribute("studentForm", student);

        return "querySearch";
    }


}
