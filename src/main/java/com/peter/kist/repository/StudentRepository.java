package com.peter.kist.repository;

import com.peter.kist.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * Query for search all students that have marks higher than average for specified subject and group
     */
//    @Query(value = "SELECT student FROM Student s JOIN ")
//    public List<Student> customQuery1(Integer groupId, Integer subjectId);
}
