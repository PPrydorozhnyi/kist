package com.peter.kist.model.converter;

import com.peter.kist.model.dto.StudentMarkDTO;
import com.peter.kist.model.entity.StudentMark;
import com.peter.kist.repository.MarkRepository;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.repository.TeacherPlanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentMarkDtoToInstanceConverter implements Converter<StudentMarkDTO, StudentMark> {

    private final MarkRepository markRepository;

    private final StudentRepository studentRepository;

    private final TeacherPlanRepository teacherPlanRepository;

    private final ModelMapper mapper;

    @Override
    public StudentMark convert(StudentMarkDTO studentMarkDTO) {

        StudentMark studentMark = mapper.map(studentMarkDTO, StudentMark.class);

        studentMark.setMark(markRepository.getOne(studentMarkDTO.getMark().getId()));
        studentMark.setStudent(studentRepository.getOne(studentMarkDTO.getStudent().getId()));
        studentMark.setTeacherPlan(teacherPlanRepository.getOne(studentMarkDTO.getTeacherPlan().getId()));

        return studentMark;
    }
}
