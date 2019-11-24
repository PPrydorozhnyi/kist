package com.peter.kist.repository;

import com.peter.kist.model.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {

    StudentGroup findStudentGroupByStudentIdAndGroupId(Integer studentId, Integer groupId);

    @Modifying
    @Transactional
    void deleteByStudentIdAndGroupId(Integer studentId, Integer groupId);
}

