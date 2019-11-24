package com.peter.kist.service.impl;

import com.peter.kist.model.entity.StudentGroup;
import com.peter.kist.repository.StudentGroupRepository;
import com.peter.kist.service.StudentGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;

    @Override
    public StudentGroup createStudentGroup(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public StudentGroup editStudentGroup(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public StudentGroup getStudentGroup(Integer studentId, Integer groupId) {
        return studentGroupRepository.findStudentGroupByStudentIdAndGroupId(studentId, groupId);
    }

    @Override
    public void deleteStudentGroup(Integer studentId, Integer groupId) {
        studentGroupRepository.deleteByStudentIdAndGroupId(studentId, groupId);
    }

    @Override
    public List<StudentGroup> findAll() {
        return studentGroupRepository.findAll();
    }

}
