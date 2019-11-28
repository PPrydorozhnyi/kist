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

    /**
     * Query for search all students that have marks higher than average for specified group
     */
    @Query(value = "SELECT s FROM Student s JOIN s.studentMarks sm JOIN s.studentGroups sg JOIN sm.mark m JOIN sg.group g " +
            "WHERE g.id = :groupId " +
            "AND m.value > (SELECT avg(m.value) FROM Student s JOIN s.studentMarks sm JOIN s.studentGroups sg JOIN sm.mark m JOIN sg.group g " +
            "WHERE g.id = :groupId)")
    List<Student> studentWithMarksMoreThanAverageFromOneGroup(@Param("groupId") Integer groupId);

    @Query(value = "SELECT s FROM Student s JOIN s.violations v JOIN v.violationKind vk " +
            "WHERE vk.id = :violationKindId")
    List<Student> studentWithOneViolationKind(@Param("violationKindId") Integer violationKindId);

    @Query(value = "SELECT s.*, p.* FROM pr_student s\n" +
            "JOIN pr_person p ON s.student_id = p.person_id\n" +
            "JOIN pr_violation v ON p.person_id = v.person_id\n" +
            "JOIN pr_punish_kind pk ON v.punish_kind_id = pk.punish_kind_id \n" +
            "WHERE v.punish_kind_id = (SELECT need_id FROM (SELECT COUNT(pk.punish_kind_id) count_violations, pk.punish_kind_id need_id FROM pr_violation v\n" +
            "JOIN pr_punish_kind pk ON v.punish_kind_id = pk.punish_kind_id\n" +
            "GROUP BY pk.punish_kind_id) counter\n" +
            "WHERE count_violations = (SELECT MAX(count_violations) FROM (SELECT COUNT(pk.punish_kind_id) count_violations, pk.punish_kind_id need_id FROM pr_violation v\n" +
            "JOIN pr_punish_kind pk ON v.punish_kind_id = pk.punish_kind_id\n" +
            "GROUP BY pk.punish_kind_id) kind));", nativeQuery = true)
    List<Student> studentThirdQuery();

    @Query("SELECT s FROM Student s JOIN s.personPrivilege pp JOIN pp.privilege p " +
            "WHERE p.id = ?1 " +
            "AND pp.beginDate = ?2 " +
            "AND pp.endDate = ?3")
    List<Student> getStudentsByPrivilegeAndBeginAndEnd(Integer privilegeId, Date startDate, Date endDate);

    @Query("SELECT s FROM Student s JOIN s.violations v JOIN v.order o JOIN o.orderKind ok " +
            "WHERE v.violationDate = ?1 " +
            "AND o.orderDate = ?2 " +
            "AND ok.name = 'About skip lesson'")
    List<Student> getStudentsByViolationDate(Date violationDate, Date orderDate);

    @Query("SELECT DISTINCT s FROM Student s JOIN s.studentGroups sg JOIN sg.group g" +
            " JOIN g.speciality spec JOIN spec.cafedra caf JOIN s.studentMarks sm JOIN sm.mark m " +
            "WHERE spec.id = ?1 " +
            "AND caf.name IN ('TK', 'AUTS') " +
            "AND g.groupCreateDate BETWEEN '2016-01-01' AND '2016-12-31' " +
            "AND m.id = ?2")
    List<Student> getStudentsBySpecialityAndMark(Integer specialityId, Integer markId);
    //
    @Modifying
    @Transactional
    void deleteStudentById(Integer id);
}
