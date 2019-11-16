package com.peter.kist.service;

import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Mark;
import com.peter.kist.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student editStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    List<Student> findAll();

    List<Group> getGroupsForStudent(Integer id);

    List<Mark> getMarksForStudent(Integer id);
}
