package com.peter.kist.service;

import com.peter.kist.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student editStudent(Student student);

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    List<Student> findAll();
}
