package com.peter.kist.controller;

import com.peter.kist.model.dto.CafedraDTO;
import com.peter.kist.model.entity.Cafedra;
import com.peter.kist.service.CafedraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.CAFEDRA_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cafedra")
public class CafedraController {

    private final CafedraService cafedraService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getCafedra(Model model, @PathVariable Integer id) {

        log.debug("getCafedra");

        Cafedra cafedra = cafedraService.getCafedra(id);

        model.addAttribute("cafedraForm", mapper.map(cafedra, CafedraDTO.class));

        return "cafedraView";
    }

    @GetMapping("/create")
    public String createCafedra(Model model) {

        log.debug("createCafedra");

        model.addAttribute("cafedraForm", new CafedraDTO());

        return "cafedraCreation";
    }

    @PostMapping("/create")
    public String createCafedra(@ModelAttribute("cafedraForm") CafedraDTO cafedraForm, BindingResult bindingResult) {

        log.debug("Cafedra creation");

        Cafedra cafedra = mapper.map(cafedraForm, Cafedra.class);

        if (bindingResult.hasErrors()) {
            return "cafedraCreation";
        }

        cafedraService.createCafedra(cafedra);

        return "redirect:/cafedra/" + cafedra.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("cafedraForm") CafedraDTO cafedra, Model model) {
        log.debug("editCafedra");

        return "cafedraCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteCafedra");

        cafedraService.deleteCafedra(id);

        return "redirect:/cafedra/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllCafedra");

        List<Cafedra> cafedras = cafedraService.findAll();

        model.addAttribute("cafedras", mapper.map(cafedras, CAFEDRA_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "cafedraTableView";
    }
}
