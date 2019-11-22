package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Group;
import com.peter.kist.model.entity.Mark;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.entity.StudentMark;
import com.peter.kist.repository.StudentRepository;
import com.peter.kist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        if (student.getId() != null) {
            student = updateStudent(student);
        }
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

    //TODO refactor to repository method
    @Override
    public List<Mark> getMarksForStudent(Integer id) {
        Student student = studentRepository.getOne(id);
        return student.getStudentMarks().stream()
                .map(StudentMark::getMark)
                .collect(Collectors.toList());
    }

    private Student updateStudent(Student person) {
        Student personFromCache = studentRepository.getOne(person.getId());
        BeanUtils.copyProperties(person, personFromCache, "id", "lessons", "teacherPlans",
                "violations", "personPrivilege");
        return personFromCache;
    }

}
