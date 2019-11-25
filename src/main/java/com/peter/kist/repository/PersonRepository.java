package com.peter.kist.repository;

import com.peter.kist.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Modifying
    @Transactional
    void deletePersonById(Integer id);

    /**
     * Query for search all teachers that have exams for specified semester and subject
     */
    @Query("SELECT DISTINCT p FROM Person p JOIN p.teacherPlans t JOIN t.subject s " +
            "JOIN t.semester sem " +
            "WHERE s.id = ?3 " +
            "AND sem.teachBeginDate = ?1 " +
            "AND sem.teachEndDate = ?2 " +
            "AND t.testKind.id = 1 " +
            "AND p.id NOT IN ( " +
            "SELECT s.id FROM Student s)")
    List<Person> findPersonBySubjectAndSemester(Date startDate, Date endDate, Integer subjectId);

    @Query("SELECT p FROM Person p " +
            "WHERE p.id NOT IN ( " +
            "SELECT s.id FROM Student s)")
    List<Person> findTeachers();

}
