package com.peter.kist.controller;

import com.peter.kist.model.dto.first.AlternativeInitDto;
import com.peter.kist.model.dto.first.AlternativeInputDto;
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
    model.addAttribute("init", new AlternativeInitDto());
    return "lab1/firstLab";
  }

  @PostMapping("/input")
  public String init(@ModelAttribute("init") AlternativeInitDto alternativeInitDto, Model model) {
    log.debug("init [alternativeInitDto={}, model={}]", alternativeInitDto, model);

    final var inputDto = new AlternativeInputDto();
    inputDto.setAmountOfExpert(alternativeInitDto.getAmountOfExpert());
    inputDto.setAmountOfAlternative(alternativeInitDto.getAmountOfAlternative());

    model.addAttribute("input", inputDto);
    model.addAttribute("amountOfExpert", alternativeInitDto.getAmountOfExpert());
    model.addAttribute("amountOfAlternative", alternativeInitDto.getAmountOfAlternative());

    return "lab1/firstLabTable";
  }

  @PostMapping("/calculate")
  public String init(@ModelAttribute("input") AlternativeInputDto alternativeInputDto,
                     Model model) {
    log.debug("init [inputDto={}, model={}]", alternativeInputDto, model);

    final var firstMethod =
        new FirstMethod(alternativeInputDto.getInputValues(),
            alternativeInputDto.getAmountOfExpert(),
            alternativeInputDto.getAmountOfAlternative());
    final var marks = firstMethod.calculateMarks();

    model.addAttribute("results", marks);

    return "lab1/firstLabResult";
  }

}
