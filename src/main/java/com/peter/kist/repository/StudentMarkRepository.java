package com.peter.kist.repository;

import com.peter.kist.model.entity.StudentMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {

    StudentMark findStudentTeacherPlanByStudentIdAndTeacherPlanId(Integer studentId, Integer teacherPlanId);
    
    @Modifying
    @Transactional
    void deleteByStudentIdAndTeacherPlanId(Integer studentId, Integer teacherPlanId);
}
