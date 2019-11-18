package com.peter.kist.controller;

import com.peter.kist.model.dto.LessonKindDTO;
import com.peter.kist.model.entity.LessonKind;
import com.peter.kist.service.LessonKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.LESSON_KIND_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/lesson-kind")
public class LessonKindController {

    private final LessonKindService lessonKindService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getLessonKind(Model model, @PathVariable Integer id) {

        log.debug("getLessonKind");

        LessonKind lessonKind = lessonKindService.getLessonKind(id);

        model.addAttribute("lessonKindForm", mapper.map(lessonKind, LessonKindDTO.class));

        return "lessonKindView";
    }

    @GetMapping("/create")
    public String createLessonKind(Model model) {

        log.debug("createLessonKind");

        model.addAttribute("lessonKindForm", new LessonKindDTO());

        return "lessonKindCreation";
    }

    @PostMapping("/create")
    public String createLessonKind(@ModelAttribute("lessonKindForm") LessonKindDTO lessonKindForm, BindingResult bindingResult) {

        log.debug("LessonKind creation");

        LessonKind lessonKind = mapper.map(lessonKindForm, LessonKind.class);

        if (bindingResult.hasErrors()) {
            return "lessonKindCreation";
        }

        lessonKindService.createLessonKind(lessonKind);

        return "redirect:/lesson-kind/" + lessonKind.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("lessonKindForm") LessonKindDTO lessonKind, Model model) {
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

        model.addAttribute("lessonKinds", mapper.map(lessonKinds, LESSON_KIND_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "lessonKindTableView";
    }
}
