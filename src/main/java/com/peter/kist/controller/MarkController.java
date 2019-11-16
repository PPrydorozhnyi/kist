package com.peter.kist.controller;


import com.peter.kist.model.Mark;
import com.peter.kist.service.MarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/mark")
public class MarkController {
    private final MarkService markService;

    @GetMapping("/{id}")
    public String getMark(Model model, @PathVariable Integer id) {

        log.debug("getMark");

        Mark mark = markService.getMark(id);

        model.addAttribute("markForm", mark);

        return "markView";
    }

    @GetMapping("/create")
    public String createMark(Model model) {

        log.debug("createMark");

        Mark mark = new Mark();

        model.addAttribute("markForm", mark);

        return "markCreation";
    }

    @PostMapping("/create")
    public String createMark(@ModelAttribute("markForm") Mark markForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Mark creation");

        if (bindingResult.hasErrors()) {
            return "markCreation";
        }

        markService.createMark(markForm);

        return "redirect:/mark/" + markForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("markForm") Mark mark, Model model) {
        log.debug("editMark");

        return "markCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteMark");

        markService.deleteMark(id);

        return "redirect:/mark/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllMark");

        List<Mark> mark = markService.findAll();

        model.addAttribute("mark", mark);

        model.addAttribute("deletedUserName", null);

        return "markTableView";
    }
}
