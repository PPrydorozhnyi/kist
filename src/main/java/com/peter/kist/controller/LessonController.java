package com.peter.kist.controller;

import com.peter.kist.model.entity.Lesson;
import com.peter.kist.service.LessonService;
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
@RequiredArgsConstructor(onConstructor_={@Autowired})
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/{id}")
    public String getLesson(Model model, @PathVariable Integer id) {

        log.debug("getLesson");

        Lesson lesson = lessonService.getLesson(id);

        model.addAttribute("lessonForm", lesson);

        return "lessonView";
    }

    @GetMapping("/create")
    public String createLesson(Model model) {

        log.debug("createLesson");

        Lesson lesson = new Lesson();

        model.addAttribute("lessonForm", lesson);

        return "lessonCreation";
    }

    @PostMapping("/create")
    public String createLesson(@ModelAttribute("lessonForm") Lesson lessonForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);

        log.debug("Lesson creation");

        if (bindingResult.hasErrors()) {
            return "lessonCreation";
        }

        lessonService.createLesson(lessonForm);

        return "redirect:/lesson/" + lessonForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("lessonForm") Lesson lesson, Model model) {
        log.debug("editLesson");

        return "lessonCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteLesson");

        lessonService.deleteLesson(id);

        return "redirect:/lesson/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllLesson");

        List<Lesson> lessons = lessonService.findAll();

        model.addAttribute("lessons", lessons);

        model.addAttribute("deletedUserName", null);

        return "lessonTableView";
    }

}
