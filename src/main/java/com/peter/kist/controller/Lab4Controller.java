package com.peter.kist.controller;

import com.peter.kist.model.dto.fourth.ParetoInitDto;
import com.peter.kist.model.dto.fourth.ParetoInputDto;
import com.peter.kist.model.dto.fourth.ParetoResultDto;
import com.peter.kist.model.dto.third.LaplaceInitDto;
import com.peter.kist.model.dto.third.LaplaceInputDto;
import com.peter.kist.service.FourthMethod;
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
@RequestMapping("/pareto")
public class Lab4Controller {

    @GetMapping
    public String getInitial(Model model) {
        log.debug("getInittial [model={}]", model);

        model.addAttribute("init", new ParetoInitDto());

        return "lab4/fourthLab";
    }

    @PostMapping("/input")
    public String init(@ModelAttribute("init") ParetoInitDto laplaceInitDto, Model model) {
        log.debug("init [LaplaceInitDto={}, model={}]", laplaceInitDto, model);

        final var inputDto = new ParetoInputDto();
        inputDto.setAmountOfExperts(laplaceInitDto.getAmountOfExperts());
        inputDto.setAmountOfAlternatives(laplaceInitDto.getAmountOfAlternatives());

        model.addAttribute("input", inputDto);
        model.addAttribute("amountOfAlternatives", laplaceInitDto.getAmountOfAlternatives());
        model.addAttribute("amountOfExperts", laplaceInitDto.getAmountOfExperts());

        return "lab4/fourthLabTable";
    }

    @PostMapping("/calculate")
    public String init(@ModelAttribute("input") ParetoInputDto inputDto, Model model) {
        log.debug("init [inputDto={}, model={}]", inputDto, model);

        final var paretoResultDto = new FourthMethod()
            .calculateAll(inputDto.getInputValues(), inputDto.getAmountOfAlternatives());
        model.addAttribute("results", paretoResultDto);

        return "lab4/fourthLabResult";
    }
}
