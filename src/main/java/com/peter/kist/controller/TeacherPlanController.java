package com.peter.kist.controller;

import com.peter.kist.model.dto.TeacherPlanDTO;
import com.peter.kist.model.dto.SemesterDTO;
import com.peter.kist.model.dto.GroupDTO;
import com.peter.kist.model.dto.PersonDTO;
import com.peter.kist.model.dto.TestKindDTO;
import com.peter.kist.model.dto.SubjectDTO;

import com.peter.kist.model.entity.TeacherPlan;
import com.peter.kist.model.entity.Semester;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Person;
import com.peter.kist.model.entity.TestKind;
import com.peter.kist.model.entity.Subject;

import com.peter.kist.service.TeacherPlanService;
import com.peter.kist.service.SemesterService;
import com.peter.kist.service.GroupService;
import com.peter.kist.service.PersonService;
import com.peter.kist.service.TestKindService;
import com.peter.kist.service.SubjectService;

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
import java.util.Date;
import java.util.Map;

import static com.peter.kist.AppConstants.*;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/teacher-plan")
public class TeacherPlanController {
    private static final String TEACHER_PLAN_CREATION_PAGE = "teacher-plan/teacherPlanCreation";

    private final TeacherPlanService teacherPlanService;

    private final PersonService personService;

    private final TestKindService testKindService;

    private final GroupService groupService;

    private final SemesterService semesterService;

    private final SubjectService subjectService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getTeacherPlan(Model model, @PathVariable Integer id) {

        log.debug("getTeacherPlan");

        TeacherPlan teacherPlan = teacherPlanService.getTeacherPlan(id);

        model.addAttribute("teacherPlanForm", mapper.map(teacherPlan, TeacherPlanDTO.class));

        return "teacher-plan/teacherPlanView";
    }

    @GetMapping("/create")
    public String createTeacherPlan(Model model) {

        log.debug("createTeacherPlan");

        List<Semester> semesters = semesterService.findAll();

        List<Group> groups = groupService.findAll();

        List<Person> testers = personService.getTeachers();

        List<TestKind> testKinds = testKindService.findAll();

        List<Subject> subjects = subjectService.findAll();

        final Map<String, Object> map = Map.of(
                "teacherPlanForm", new TeacherPlanDTO(new SemesterDTO(), new GroupDTO(), new PersonDTO(), new TestKindDTO(), new SubjectDTO()),
                "semesters", mapper.map(semesters, SEMESTER_LIST_TYPE),
                "groups", mapper.map(groups, GROUP_LIST_TYPE),
                "testers", mapper.map(testers, PERSON_SHORT_LIST_TYPE),
                "testKinds", mapper.map(testKinds, TEST_KIND_LIST_TYPE),
                "subjects", mapper.map(subjects, SUBJECT_LIST_TYPE));

        model.addAllAttributes(map);

        return TEACHER_PLAN_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createTeacherPlan(@ModelAttribute("teacherPlanForm") TeacherPlanDTO teacherPlanForm, BindingResult bindingResult) {

        log.debug("TeacherPlan creation");

        TeacherPlan teacherPlan = conversionService.convert(teacherPlanForm, TeacherPlan.class);

        if (bindingResult.hasErrors()) {
            return TEACHER_PLAN_CREATION_PAGE;
        }

        teacherPlan = teacherPlanService.createTeacherPlan(teacherPlan);

        return "redirect:/teacher-plan/" + teacherPlan.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("teacherPlanForm") TeacherPlanDTO teacherPlan, Model model) {
        log.debug("editTeacherPlan");

        List<Semester> semesters = semesterService.findAll();

        List<Group> groups = groupService.findAll();

        List<Person> testers = personService.getTeachers();

        List<TestKind> testKinds = testKindService.findAll();

        List<Subject> subjects = subjectService.findAll();

        final Map<String, Object> map = Map.of(
                "semesters", mapper.map(semesters, SEMESTER_LIST_TYPE),
                "groups", mapper.map(groups, GROUP_LIST_TYPE),
                "testers", mapper.map(testers, PERSON_SHORT_LIST_TYPE),
                "testKinds", mapper.map(testKinds, TEST_KIND_LIST_TYPE),
                "subjects", mapper.map(subjects, SUBJECT_LIST_TYPE));

        model.addAllAttributes(map);

        return TEACHER_PLAN_CREATION_PAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteTeacherPlan");

        teacherPlanService.deleteTeacherPlan(id);

        return "redirect:/teacher-plan/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllTeacherPlan");

        List<TeacherPlan> teacherPlans = teacherPlanService.findAll();

        model.addAttribute("teacherPlans", mapper.map(teacherPlans, TEACHER_PLAN_LIST_TYPE));

        return "teacher-plan/teacherPlanTableView";
    }
    
    
}
