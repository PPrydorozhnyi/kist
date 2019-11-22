package com.peter.kist.service.impl;

import com.peter.kist.model.entity.TeacherPlan;
import com.peter.kist.repository.TeacherPlanRepository;
import com.peter.kist.service.TeacherPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherPlanServiceImpl implements TeacherPlanService {

    private final TeacherPlanRepository teacherPlanRepository;

    @Override
    public TeacherPlan createTeacherPlan(TeacherPlan teacherPlan) {
        return teacherPlanRepository.save(teacherPlan);
    }

    @Override
    public TeacherPlan editTeacherPlan(TeacherPlan teacherPlan) {
        return teacherPlanRepository.save(teacherPlan);
    }

    @Override
    public TeacherPlan getTeacherPlan(Integer id) {
        return teacherPlanRepository.getOne(id);
    }

    @Override
    public void deleteTeacherPlan(Integer id) {
        teacherPlanRepository.deleteTeacherPlanById(id);
    }

    @Override
    public List<TeacherPlan> findAll() {
        return teacherPlanRepository.findAll();
    }

}
