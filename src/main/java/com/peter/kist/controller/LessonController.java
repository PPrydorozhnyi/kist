package com.peter.kist.controller;

import com.peter.kist.model.dto.LessonDTO;
import com.peter.kist.model.dto.LessonKindDTO;
import com.peter.kist.model.entity.Lesson;
import com.peter.kist.model.entity.LessonKind;
import com.peter.kist.model.entity.Person;
import com.peter.kist.service.LessonKindService;
import com.peter.kist.service.LessonService;
import com.peter.kist.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.*;

//  TODO change mapping module for child relations

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    private final PersonService personService;

    private final LessonKindService lessonKindService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getLesson(Model model, @PathVariable Integer id) {

        log.debug("getLesson");

        Lesson lesson = lessonService.getLesson(id);

        final Map<String, Object> lessonForm = Map.of("lessonForm", mapper.map(lesson, LessonDTO.class),
                "teacher", mapper.map(lesson.getTeacher(), Person.class),
                "lessonKind", mapper.map(lesson.getLessonKind(), LessonKindDTO.class));

        model.addAllAttributes(lessonForm);

        return "lessonView";
    }

    @GetMapping("/create")
    public String createLesson(Model model) {

        log.debug("createLesson");

        List<Person> teachers = personService.getTeachers();

        List<LessonKind> lessonKinds = lessonKindService.findAll();

        Map<String, Object> map = Map.of("lessonForm", new LessonDTO(),
                "teachers", mapper.map(teachers, PERSON_LIST_TYPE),
                "lessonKinds", mapper.map(lessonKinds, LESSON_KIND_LIST_TYPE));

        model.addAllAttributes(map);

        return "lessonCreation";
    }

    @PostMapping("/create")
    public String createLesson(@ModelAttribute("lessonForm") LessonDTO lessonForm, BindingResult bindingResult) {

        log.debug("Lesson creation");

        Lesson lesson = conversionService.convert(lessonForm, Lesson.class);

        if (bindingResult.hasErrors()) {
            return "lessonCreation";
        }

        lesson = lessonService.createLesson(lesson);

        return "redirect:/lesson/" + lesson.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("lessonForm") LessonDTO lesson, Model model) {
        log.debug("editLesson");

        List<Person> teachers = personService.getTeachers();

        List<LessonKind> lessonKinds = lessonKindService.findAll();

        var map = Map.of("teachers", mapper.map(teachers, PERSON_LIST_TYPE),
                "lessonKinds", mapper.map(lessonKinds, LESSON_KIND_LIST_TYPE));

        model.addAllAttributes(map);

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

        model.addAttribute("lessons", mapper.map(lessons, LESSON_LIST_TYPE));

        model.addAttribute("deletedUserName", null);

        return "lessonTableView";
    }

}
