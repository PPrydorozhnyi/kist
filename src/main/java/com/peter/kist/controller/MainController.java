package com.peter.kist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

  @GetMapping
  public String getInitial() {
    log.debug("initial point");
    return "main/index";
  }

}
