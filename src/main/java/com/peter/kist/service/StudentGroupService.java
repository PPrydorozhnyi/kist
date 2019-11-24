package com.peter.kist.service;

import com.peter.kist.model.entity.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    StudentGroup createStudentGroup(StudentGroup studentGroup);

    StudentGroup editStudentGroup(StudentGroup studentGroup);

    StudentGroup getStudentGroup(Integer studentId, Integer groupId);

    void deleteStudentGroup(Integer studentId, Integer groupId);

    List<StudentGroup> findAll();
}
