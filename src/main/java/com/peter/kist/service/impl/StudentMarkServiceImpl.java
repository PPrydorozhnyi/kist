package com.peter.kist.service.impl;

import com.peter.kist.model.entity.StudentMark;
import com.peter.kist.repository.StudentMarkRepository;
import com.peter.kist.service.StudentMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentMarkServiceImpl implements StudentMarkService {

    private final StudentMarkRepository studentMarkRepository;

    @Override
    public StudentMark createStudentMark(StudentMark studentMark) {
        return studentMarkRepository.save(studentMark);
    }

    @Override
    public StudentMark editStudentMark(StudentMark studentMark) {
        return studentMarkRepository.save(studentMark);
    }

    @Override
    public StudentMark getStudentMark(Integer studentId, Integer teacherPlanId) {
        return studentMarkRepository.findStudentTeacherPlanByStudentIdAndTeacherPlanId(studentId, teacherPlanId);
    }

    @Override
    public void deleteStudentMark(Integer studentId, Integer teacherPlanId) {
        studentMarkRepository.deleteByStudentIdAndTeacherPlanId(studentId, teacherPlanId);
    }

    @Override
    public List<StudentMark> findAll() {
        return studentMarkRepository.findAll();
    }

}
