package com.peter.kist.service;

import com.peter.kist.model.entity.StudentMark;

import java.util.List;

public interface StudentMarkService {

    StudentMark createStudentMark(StudentMark studentMark);

    StudentMark editStudentMark(StudentMark studentMark);

    StudentMark getStudentMark(Integer studentId, Integer teacherPlanId);

    void deleteStudentMark(Integer studentId, Integer teacherPlanId);

    List<StudentMark> findAll();
}
