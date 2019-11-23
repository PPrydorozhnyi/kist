package com.peter.kist.service;

import com.peter.kist.model.entity.TeacherPlan;

import java.util.List;

public interface TeacherPlanService {

    TeacherPlan createTeacherPlan(TeacherPlan teacherPlan);

    TeacherPlan editTeacherPlan(TeacherPlan teacherPlan);

    TeacherPlan getTeacherPlan(Integer id);

    void deleteTeacherPlan(Integer id);

    List<TeacherPlan> findAll();
}
