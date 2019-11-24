package com.peter.kist.repository;

import com.peter.kist.model.entity.Student;
import com.peter.kist.model.enums.MarkNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Query("SELECT s FROM Student s JOIN s.personPrivilege pp JOIN pp.privilege p " +
            "WHERE p.id = ?1 " +
            "AND pp.beginDate = ?2 " +
            "AND pp.endDate = ?3")
    List<Student> getStudentsByPrivilegeAndBeginAndEnd(Integer privilegeId, Date startDate, Date endDate);

    @Query("SELECT s FROM Student s JOIN s.violations v JOIN v.order o JOIN o.orderKind ok " +
            "WHERE v.violationDate = ?1 " +
            "AND o.orderDate = ?2 " +
            "AND ok.name = 'Skip Lesson'")
    List<Student> getStudentsByViolationDate(Date violationDate, Date orderDate);

    @Query("SELECT DISTINCT s FROM Student s JOIN s.studentGroups sg JOIN sg.group g" +
            " JOIN g.speciality spec JOIN spec.cafedra caf JOIN s.studentMarks sm JOIN sm.mark m " +
            "WHERE spec.shifr = '151' " +
            "AND caf.shifr IN ('TK', 'AUTS') " +
            "AND sg.puttingDate BETWEEN '2016-01-01' AND '2016-12-31' " +
            "AND m.value = 100")
    List<Student> getStudentsBySpecialityAndMark(Integer specialityId, MarkNames mark);

    @Modifying
    @Transactional
    void deleteStudentById(Integer id);
}
