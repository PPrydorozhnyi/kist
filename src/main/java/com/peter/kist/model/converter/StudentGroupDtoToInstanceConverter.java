package com.peter.kist.model.converter;

import com.peter.kist.model.dto.StudentGroupDTO;
import com.peter.kist.model.entity.StudentGroup;
import com.peter.kist.repository.GroupRepository;
import com.peter.kist.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentGroupDtoToInstanceConverter implements Converter<StudentGroupDTO, StudentGroup> {

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    private final ModelMapper mapper;

    @Override
    public StudentGroup convert(StudentGroupDTO studentGroupDTO) {

        StudentGroup studentGroup = mapper.map(studentGroupDTO, StudentGroup.class);

        studentGroup.setStudent(studentRepository.getOne(studentGroupDTO.getStudent().getId()));
        studentGroup.setGroup(groupRepository.getOne(studentGroupDTO.getGroup().getId()));

        return studentGroup;
    }
}
