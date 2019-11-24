package com.peter.kist.controller;

import com.peter.kist.model.dto.MarkDTO;
import com.peter.kist.model.dto.StudentDTO;
import com.peter.kist.model.dto.StudentMarkDTO;
import com.peter.kist.model.dto.TeacherPlanDTO;
import com.peter.kist.model.entity.Mark;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.entity.StudentMark;
import com.peter.kist.model.entity.TeacherPlan;
import com.peter.kist.service.MarkService;
import com.peter.kist.service.StudentMarkService;
import com.peter.kist.service.StudentService;
import com.peter.kist.service.TeacherPlanService;
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

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/student-mark")
public class StudentMarkController {

    private static final String STUDENT_MARK_CREATION_PAGE = "student-mark/studentMarkCreation";

    private final StudentMarkService studentMarkService;

    private final StudentService studentService;

    private final MarkService markService;

    private final TeacherPlanService teacherPlanService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/student/{studentId}/teacherPlan/{teacherPlanId}")
    public String getStudentMark(Model model, @PathVariable Integer studentId, @PathVariable Integer teacherPlanId) {

        log.debug("getStudentMark");

        StudentMark studentMark = studentMarkService.getStudentMark(studentId, teacherPlanId);

        model.addAttribute("studentMarkForm", mapper.map(studentMark, StudentMarkDTO.class));

        return "student-mark/studentMarkView";
    }

    @GetMapping("/create")
    public String createStudentMark(Model model) {

        log.debug("createStudentMark");

        List<Student> students = studentService.findAll();

        List<Mark> marks = markService.findAll();

        List<TeacherPlan> teacherPlans = teacherPlanService.findAll();

        final Map<String, Object> map = Map.of(
                "studentMarkForm", new StudentMarkDTO(new MarkDTO(), new StudentDTO(), new TeacherPlanDTO()),
                "marks", mapper.map(marks, MARK_LIST_TYPE),
                "students", mapper.map(students, STUDENT_LIST_TYPE),
                "teacherPlans", mapper.map(teacherPlans, TEACHER_PLAN_LIST_TYPE)
                );

        model.addAllAttributes(map);

        return STUDENT_MARK_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createStudentMark(@ModelAttribute("studentMarkForm") StudentMarkDTO studentMarkForm, BindingResult bindingResult) {

        log.debug("StudentMark creation");

        StudentMark studentMark = conversionService.convert(studentMarkForm, StudentMark.class);

        if (bindingResult.hasErrors()) {
            return STUDENT_MARK_CREATION_PAGE;
        }

        studentMark = studentMarkService.createStudentMark(studentMark);

        return String.format("redirect:/student-mark/student/%o/teacherPlan/%o", studentMark.getStudent().getId(), studentMark.getTeacherPlan().getId());
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentMarkForm") StudentMarkDTO studentMark, Model model) {
        log.debug("editStudentMark");

        List<Mark> marks = markService.findAll();
        List<Student> students = studentService.findAll();
        List<TeacherPlan> teacherPlans = teacherPlanService.findAll();

        final Map<String, Object> map = Map.of(
                "marks", mapper.map(marks, MARK_LIST_TYPE),
                "students", mapper.map(students, STUDENT_LIST_TYPE),
                "teacherPlans", mapper.map(teacherPlans, TEACHER_PLAN_LIST_TYPE)
                );

        model.addAllAttributes(map);

        return STUDENT_MARK_CREATION_PAGE;
    }

    @DeleteMapping("/student/{studentId}/teacherPlan/{teacherPlanId}")
    public String delete(@PathVariable Integer studentId, @PathVariable Integer teacherPlanId) {

        log.debug("deleteStudentMark");

        studentMarkService.deleteStudentMark(studentId, teacherPlanId);

        return "redirect:/student-mark/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllStudentMark");

        List<StudentMark> studentMarks = studentMarkService.findAll();

        model.addAttribute("studentMarks", mapper.map(studentMarks, STUDENT_MARK_LIST_TYPE));

        return "student-mark/studentMarkTableView";
    }

}
