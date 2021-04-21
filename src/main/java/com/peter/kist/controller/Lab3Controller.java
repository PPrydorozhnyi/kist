package com.peter.kist.controller;

import com.peter.kist.model.dto.third.LaplaceInitDto;
import com.peter.kist.model.dto.third.LaplaceInputDto;
import com.peter.kist.service.ThirdMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/laplace")
public class Lab3Controller {
    @GetMapping
    public String getInitial(Model model) {
        log.debug("getInittial [model={}]", model);

        model.addAttribute("init", new LaplaceInitDto());

        return "lab3/thirdLab";
    }

    @PostMapping("/input")

    public String init(@ModelAttribute("init") LaplaceInitDto laplaceInitDto, Model model) {
        log.debug("init [LaplaceInitDto={}, model={}]", laplaceInitDto, model);

        final var inputDto = new LaplaceInputDto();
        inputDto.setAmountOfCondition(laplaceInitDto.getAmountOfCondition());
        inputDto.setAmountOfAlternative(laplaceInitDto.getAmountOfAlternative());

        model.addAttribute("input", inputDto);
        model.addAttribute("amountOfAlternative", laplaceInitDto.getAmountOfAlternative());
        model.addAttribute("amountOfCondition", laplaceInitDto.getAmountOfCondition());

        return "lab3/thirdLabTable";
    }

    @PostMapping("/calculate")
    public String init(@ModelAttribute("input") LaplaceInputDto inputDto, Model model) {
        log.debug("init [inputDto={}, model={}]", inputDto, model);

        final var laplaceResult =
                new ThirdMethod().calculateAll(inputDto.getInputValues(), inputDto.getAmountOfAlternative(), inputDto.getAmountOfCondition());

        model.addAttribute("results", laplaceResult);

        return "lab3/thirdLabResult";
    }
}
