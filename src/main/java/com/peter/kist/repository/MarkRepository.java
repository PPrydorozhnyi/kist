package com.peter.kist.repository;

import com.peter.kist.model.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Modifying
    @Transactional
    void deleteMarkById(Integer id);
}
