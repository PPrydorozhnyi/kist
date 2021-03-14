package com.peter.kist.controller;

import com.peter.kist.model.dto.first.InitDto;
import com.peter.kist.model.dto.first.InputDto;
import com.peter.kist.service.FirstMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/alternative")
public class Lab1Controller {

    @GetMapping
    public String getInitial(Model model) {
        log.debug("getInittial [model={}]", model);

        model.addAttribute("init", new InitDto());

        return "lab1/firstLab";
    }

    @PostMapping("/input")
    public String init(@ModelAttribute("init") InitDto initDto, Model model) {
        final var inputDto = new InputDto();
        inputDto.setAmountOfExpert(initDto.getAmountOfExpert());
        inputDto.setAmountOfAlternative(initDto.getAmountOfAlternative());
        model.addAttribute("input", inputDto);
        model.addAttribute("amountOfExpert", initDto.getAmountOfExpert());
        model.addAttribute("amountOfAlternative", initDto.getAmountOfAlternative());

        return "lab1/firstLabTable";
    }

    @PostMapping("/calculate")
    public String init(@ModelAttribute("input") InputDto inputDto, Model model) {
        log.debug("init [inputDto={}, model={}]", inputDto, model);
        final var firstMethod =
            new FirstMethod(inputDto.getInputValues(), inputDto.getAmountOfExpert(),
                inputDto.getAmountOfAlternative());
        final var marks = firstMethod.calculateMarks();

        model.addAttribute("results", marks);
        return "lab1/firstLabResult";
    }

}
