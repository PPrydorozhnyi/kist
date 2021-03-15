package com.peter.kist.controller;

import com.peter.kist.model.dto.second.GurvicInitDto;
import com.peter.kist.model.dto.second.GurvicInputDto;
import com.peter.kist.service.SecondMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/gurvic")
public class Lab2Controller {

  @GetMapping
  public String getInitial(Model model) {
    log.debug("getInittial [model={}]", model);

    model.addAttribute("init", new GurvicInitDto());

    return "lab2/secondLab";
  }

  @PostMapping("/input")
  public String init(@ModelAttribute("init") GurvicInitDto gurvicInitDto, Model model) {
    log.debug("init [gurvicInitDto={}, model={}]", gurvicInitDto, model);

    final var inputDto = new GurvicInputDto();
    inputDto.setAmountOfStage(gurvicInitDto.getAmountOfStage());
    inputDto.setAmountOfSolving(gurvicInitDto.getAmountOfSolving());

    model.addAttribute("input", inputDto);
    model.addAttribute("amountOfSolving", gurvicInitDto.getAmountOfSolving());
    model.addAttribute("amountOfStage", gurvicInitDto.getAmountOfStage());

    return "lab2/secondLabTable";
  }

  @PostMapping("/calculate")
  public String init(@ModelAttribute("input") GurvicInputDto inputDto, Model model) {
    log.debug("init [inputDto={}, model={}]", inputDto, model);

    final var gurvicResult =
        new SecondMethod().calculateAll(inputDto.getInputValues(), inputDto.getAmountOfStage());

    model.addAttribute("results", gurvicResult);

    return "lab2/secondLabResult";
  }

}
