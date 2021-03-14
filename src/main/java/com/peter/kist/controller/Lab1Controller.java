package com.peter.kist.controller;

import com.peter.kist.model.dto.InitDto;
import com.peter.kist.model.dto.InputDto;
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

        return "lab1/firstLabTable";
    }

//    @PostMapping("/create")
//    public String init(@ModelAttribute("cafedraForm") CafedraDTO cafedraForm) {
//        log.debug("createCafedra [cafedraForm={}]", cafedraForm);
//
//
//
//        cafedraService.createCafedra(cafedra);
//
//        return "redirect:/cafedra/" + cafedra.getId();
//    }
//
//    @PostMapping("/edit")
//    public String edit(@ModelAttribute("cafedraForm") CafedraDTO cafedra, Model model) {
//        log.debug("editCafedra");
//
//        return CAFEDRA_CREATION_PAGE;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Integer id) {
//
//        log.debug("deleteCafedra");
//
//        cafedraService.deleteCafedra(id);
//
//        return "redirect:/cafedra/all";
//    }
//
//    @GetMapping("/all")
//    public String findAll(Model model) {
//
//        log.debug("findAllCafedra");
//
//        List<Cafedra> cafedras = cafedraService.findAll();
//
//        model.addAttribute("cafedras", mapper.map(cafedras, CAFEDRA_LIST_TYPE));
//
//        return "cafedra/cafedraTableView";
//    }
}
