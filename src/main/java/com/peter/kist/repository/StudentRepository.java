package com.peter.kist.repository;

import com.peter.kist.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * Query for search all students that have marks higher than average for specified subject and group
     */
    @Query(value = "SELECT s FROM Student s JOIN s.groups g JOIN s.marks m JOIN g.teacherPlans t JOIN t.subject subj " +
            "WHERE g.id = :groupId " +
            "AND subj.id = :subjectId " +
            "AND m.value > " +
            "   (select avg(mark.value) " +
            "       from Student st " +
            "       join st.groups gr " +
            "       join st.marks mark " +
            "       where gr.id = :groupId)")
    List<Student> studentWithMarksMoreThanAverage(@Param("groupId") Integer groupId, @Param("subjectId") Integer subjectId);
}
