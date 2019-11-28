package com.peter.kist.repository;

import com.peter.kist.model.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Modifying
    @Transactional
    void deleteMarkById(Integer id);

    @Query("SELECT m FROM Mark m JOIN m.studentMarks sm JOIN sm.student s " +
            "WHERE s.id = :studentId")
    List<Mark> findMarksByStudentId(@Param("studentId") Integer studentId);
}
