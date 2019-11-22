package com.peter.kist.repository;

import com.peter.kist.model.entity.TeacherPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherPlanRepository extends JpaRepository<TeacherPlan, Long> {
    @Modifying
    @Transactional
    void deleteTeacherPlanById(Integer id);
}
