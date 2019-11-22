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
     * Query for search all students that have marks higher than average for specified subject and group
     */
    @Query(value = "SELECT s FROM Student s")
    List<Student> customQuery1(@Param("groupId") Integer groupId, @Param("subjectId") Integer subjectId);

    @Modifying
    @Transactional
    void deleteStudentById(Integer id);
}
