package com.peter.kist.repository;

import com.peter.kist.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Modifying
    @Transactional
    void deleteGroupById(Integer id);

    @Query("SELECT g FROM Group g JOIN g.studentGroups sg JOIN sg.student s " +
            "WHERE s.id = :studentId")
    List<Group> findGroupsByStudentId(@Param("studentId") Integer studentId);

    @Query("SELECT g FROM Group g JOIN g.teacherPlans t " +
            "WHERE t.id = ?1")
    Group findGroupByTeacherPlanId(Integer teacherPlanId);
}
