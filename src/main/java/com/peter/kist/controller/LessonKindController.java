package com.peter.kist.controller;

import com.peter.kist.model.entity.LessonKind;
import com.peter.kist.service.LessonKindService;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/lesson-kind")
public class LessonKindController {

    private final LessonKindService lessonKindService;

    @GetMapping("/{id}")
    public String getLessonKind(Model model, @PathVariable Integer id) {

        log.debug("getLessonKind");

        LessonKind lessonKind = lessonKindService.getLessonKind(id);

        model.addAttribute("lessonKindForm", lessonKind);

        return "lessonKindView";
    }

    @GetMapping("/create")
    public String createLessonKind(Model model) {

        log.debug("createLessonKind");

        LessonKind lessonKind = new LessonKind();

        model.addAttribute("lessonKindForm", lessonKind);

        return "lessonKindCreation";
    }

    @PostMapping("/create")
    public String createLessonKind(@ModelAttribute("lessonKindForm") LessonKind lessonKindForm, BindingResult bindingResult) {

        log.debug("LessonKind creation");

        if (bindingResult.hasErrors()) {
            return "lessonKindCreation";
        }

        lessonKindService.createLessonKind(lessonKindForm);

        return "redirect:/lesson-kind/" + lessonKindForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("lessonKindForm") LessonKind lessonKind, Model model) {
        log.debug("editLessonKind");

        return "lessonKindCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteLessonKind");

        lessonKindService.deleteLessonKind(id);

        return "redirect:/lesson-kind/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllLessonKind");

        List<LessonKind> lessonKinds = lessonKindService.findAll();

        model.addAttribute("lessonKinds", lessonKinds);

        model.addAttribute("deletedUserName", null);

        return "lessonKindTableView";
    }
}
