package com.peter.kist.validator;

import com.peter.kist.model.dto.StudentMarkDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.StudentMark;
import com.peter.kist.model.entity.User;
import com.peter.kist.repository.GroupRepository;
import com.peter.kist.service.StudentMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentMarkValidator implements Validator {

    private final GroupRepository groupRepository;
    private final StudentMarkService studentMarkService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StudentMarkDTO studentMark = (StudentMarkDTO) o;

        final List<Group> groups = groupRepository.findGroupsByStudentId(studentMark.getStudent().getId());
        final Group group = groupRepository.findGroupByTeacherPlanId(studentMark.getTeacherPlan().getId());

        final StudentMark mark = studentMarkService.getStudentMark(studentMark.getStudent().getId(),
                studentMark.getTeacherPlan().getId());

        if (!groups.contains(group)) {
            errors.rejectValue("teacherPlan.id", "teacherPlan.incorrect");
        }

        if (mark != null) {
            errors.rejectValue("teacherPlan.id", "teacherPlan.not.unique");
        }
    }
}
