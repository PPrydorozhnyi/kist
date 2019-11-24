package com.peter.kist.repository;

import com.peter.kist.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * Query for search all students that have marks higher than average for specified group
     */
    @Query(value = "SELECT s FROM Student s JOIN s.studentMarks sm JOIN sm.teacherPlan t JOIN sm.mark m " +
            "WHERE t.group.id = :groupId " +
            "AND m.value > (" +
                "SELECT avg(m.value) FROM Student s " +
                "JOIN s.studentMarks sm " +
                "JOIN sm.mark m " +
                "JOIN sm.teacherPlan t " +
                    "WHERE t.group.id = :groupId" +
            ")")
    List<Student> studentWithMarksMoreThanAverage(@Param("groupId") Integer groupId);

    /**
     * Query for search all students that have marks in specified range and teacher for Math credit
     */
    @Query(value = "SELECT s FROM Student s JOIN s.studentMarks sm JOIN sm.teacherPlan t JOIN sm.mark m JOIN t.subject subj " +
            "WHERE t.tester.id = ?3 " +
            "AND m.value BETWEEN ?1 AND ?2 " +
            "AND t.testKind.id = 2 " +
            "AND subj.name like '%Math%'")
    List<Student> studentWithMarks(Integer min, Integer max, Integer personId);

    @Modifying
    @Transactional
    void deleteStudentById(Integer id);
}
