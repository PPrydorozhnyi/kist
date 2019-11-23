package com.peter.kist.model.converter;

import com.peter.kist.model.dto.TeacherPlanDTO;
import com.peter.kist.model.entity.TeacherPlan;
import com.peter.kist.repository.SemesterRepository;
import com.peter.kist.repository.GroupRepository;
import com.peter.kist.repository.PersonRepository;
import com.peter.kist.repository.TestKindRepository;
import com.peter.kist.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class TeacherPlanDtoToInstanceConverter implements Converter<TeacherPlanDTO, TeacherPlan> {

    private final SubjectRepository subjectRepository;

    private final SemesterRepository semesterRepository;

    private final GroupRepository groupRepository;
    
    private final PersonRepository personRepository;

    private final TestKindRepository testKindRepository;

    private final ModelMapper mapper;

    @Override
    public TeacherPlan convert(TeacherPlanDTO teacherPlanDTO) {

        TeacherPlan teacherPlan = mapper.map(teacherPlanDTO, TeacherPlan.class);

        teacherPlan.setTestKind(testKindRepository.getOne(teacherPlanDTO.getTestKind().getId()));
        teacherPlan.setTester(personRepository.getOne(teacherPlanDTO.getTester().getId()));
        teacherPlan.setGroup(groupRepository.getOne(teacherPlanDTO.getGroup().getId()));
        teacherPlan.setSemester(semesterRepository.getOne(teacherPlanDTO.getSemester().getId()));
        teacherPlan.setSubject(subjectRepository.getOne(teacherPlanDTO.getSubject().getId()));

        return teacherPlan;
    }
}
