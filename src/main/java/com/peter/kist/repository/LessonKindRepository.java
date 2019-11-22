package com.peter.kist.repository;

import com.peter.kist.model.entity.LessonKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface LessonKindRepository extends JpaRepository<LessonKind, Integer> {
    @Modifying
    @Transactional
    void deleteLessonKindById(Integer id);
}
