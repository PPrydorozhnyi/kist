package com.peter.kist.repository;

import com.peter.kist.model.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Modifying
    @Transactional
    void deleteLessonById(Integer id);

    List<Lesson> findLessonsByTeacherPlanId(Integer id);
}
