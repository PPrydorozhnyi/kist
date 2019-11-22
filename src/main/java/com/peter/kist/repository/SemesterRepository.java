package com.peter.kist.repository;

import com.peter.kist.model.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
    @Modifying
    @Transactional
    void deleteSemesterById(Integer id);
}
