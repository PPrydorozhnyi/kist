package com.peter.kist.service.impl;

import com.peter.kist.model.Group;
import com.peter.kist.model.Mark;
import com.peter.kist.model.Student;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository.getOne(id);
        studentRepository.delete(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Group> getGroupsForStudent(Integer id) {
        Student student = studentRepository.getOne(id);
        return student.getGroups();
    }

    @Override
    public List<Mark> getMarksForStudent(Integer id) {
        Student student = studentRepository.getOne(id);
        return student.getMarks();
    }

}
